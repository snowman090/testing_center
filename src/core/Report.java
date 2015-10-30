package core;

import core.db.SessionManager;
import core.event.Appointment;
import core.event.Course;
import core.event.Exam;
import core.event.Term;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

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

    // TODO: Migrate return type
    public void showDayReport(Term term){

        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Query query = session.createQuery("from Appointment as a where a.startDateTime >= :startDate and :endDate >= a.endDateTime");
            query.setTimestamp("endDate", Date.from(term.getTermEndDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            query.setTimestamp("startDate", Date.from(term.getTermStartDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            List<Appointment> list = query.list();

            ;
            term.getTermEndDate();

            for(LocalDate localDate = term.getTermStartDate(); localDate.isBefore(term.getTermEndDate().plusDays(1));localDate = localDate.plusDays(1) ){
                System.out.println(localDate.toString());
                for(Appointment appt: list){
                    if(appt.getStartDateTime().toLocalDate().equals(localDate)){
                        System.out.println(appt.getExamId()+ "|"+appt.getAppointmentID() +"|" + appt.getMadeBy());
                    }
                }
            }



            tx.commit();
        }
        catch (HibernateException he) {
            if(tx!=null){
                tx.rollback();
            }
        }
        finally {
            session.close();
        }



    }
}
