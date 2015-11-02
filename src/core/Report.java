package core;

import core.service.SessionManager;
import core.event.Appointment;
import core.event.Course;
import core.event.Exam;
import core.event.Term;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.util.Log4jConfigListener;
import sun.rmi.runtime.Log;
import test.Log4J;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Created by Zeqli on 10/7/2015.
 */
public class Report {

    private List<Exam> exams;
    private List<Course> courses;
    private List<Appointment> appointments;

    private Term startTerm;
    private Term endTerm;

    public Report() {

    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Term getEndTerm() {
        return endTerm;
    }

    public void setEndTerm(Term endTerm) {
        this.endTerm = endTerm;
    }

    public Term getStartTerm() {
        return startTerm;
    }

    public void setStartTerm(Term startTerm) {
        this.startTerm = startTerm;
    }

    public List<Appointment> getAppointments(Term term) {
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Appointment as a where a.startDateTime >= :startDate and :endDate >= a.endDateTime");
            query.setTimestamp("endDate", Date.from(term.getTermEndDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            query.setTimestamp("startDate", Date.from(term.getTermStartDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            // If query won't get any record from table, the result will be an empty list.
            appointments = query.list();


            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return appointments;
    }

    // TODO: Migrate return type
    public void showDayReport(Term term) {
        appointments = getAppointments(term);
        Log4J.log.info("------------Show report by Day------------");
        // Print A List of Entire Semester, and Appointment corresponding to each day.
        for (LocalDate localDate = term.getTermStartDate(); localDate.isBefore(term.getTermEndDate().plusDays(1)); localDate = localDate.plusDays(1)) {
            Log4J.log.info(localDate.toString());
            for (Appointment appt : appointments) {
                if (appt.getStartDateTime().toLocalDate().equals(localDate)) {
                    Log4J.log.info(appt.getExamId() + "|" + appt.getAppointmentID() + "|" + appt.getMadeBy());
                }
            }
        }

        Log4J.log.info("End of report...");
    }

    public void showWeekReport(Term term) {
        appointments = getAppointments(term);
        Log4J.log.info("------------Show report by Week------------");


        // Assume Each Semester Starts on Monday
        for (LocalDate date = term.getTermStartDate(); date.isBefore(term.getTermEndDate().plusDays(1)); date = date.plusWeeks(1)) {


            List<Appointment> list = new LinkedList<>();
            for (Appointment appt : appointments) {
                if (appt.getStartDateTime().toLocalDate().isAfter(date) && appt.getEndDateTime().toLocalDate().isBefore(date.plusWeeks(1))) {
                    list.add(appt);
                }
            }

            // Count courses.
            HashMap<String, Integer> courseCount = new HashMap<>();
            for (Appointment a:list){
                String cName = a.getExamId();

                // If Key exist
                if (courseCount.get(cName)!=null){
                    courseCount.put(cName, courseCount.get(cName) + 1);

                }
                else {
                    courseCount.put(cName, 1);
                }
            }
            String s = date.format(DateTimeFormatter.ofPattern("LLLL dd, yyyy"));
            Log4J.log.info(" Week of " + s + " ------------ " + list.size() + "Appointments");

            // Read Course
            Iterator it = courseCount.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry pair = (Map.Entry)it.next();
                Log4J.log.info(pair.getKey() + "-----------" + pair.getValue());
            }

        }
        Log4J.log.info("End of report...");

    }

    // Report Date
    public void showTermReport(Term term){
        // Read Database Using Left Join
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        Set<String> courses = new LinkedHashSet<>();
        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("select e.examName from Exam e where  :startDate <= e.startDateTime and e.endDateTime <= :endDate");
            System.out.println(Date.from(term.getTermEndDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            System.out.println(Date.from(term.getTermStartDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            query.setTimestamp("endDate", Date.from(term.getTermEndDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            query.setTimestamp("startDate", Date.from(term.getTermStartDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));


            List<String> listResult = query.list();
            for(String row : listResult){
                String s = row;
                Log4J.log.debug("Read examName from table Exam: " + s);
                courses.add(s);

            }

            tx.commit();
        } catch (HibernateException he) {
            if(tx!=null){
                tx.rollback();
            }
            Log4J.log.error("Error with Table Join", he);
        }


        Log4J.log.info("------------Show report by Year------------");
        Log4J.log.info(term.getTermName() + " starts from " + term.getTermStartDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        Iterator<String> it = courses.iterator();
        while (it.hasNext()){
            Log4J.log.info(it.next());
        }
        Log4J.log.info(term.getTermName() + " ends on " + term.getTermEndDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));


    }
}
