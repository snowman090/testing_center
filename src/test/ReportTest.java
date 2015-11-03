package test;

import core.Report;
import core.event.*;
import core.user.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import core.service.SessionManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public class ReportTest {

    public static void main(String[] args){
        Term term1 = new Term(1156,LocalDate.of(2015, 8, 22), LocalDate.of(2015, 12, 17) );
        Term term2 = new Term(1158,LocalDate.of(2015, 12, 25), LocalDate.of(2016, 1, 23));
        Term term3 = new Term(1161,LocalDate.of(2016, 1, 24), LocalDate.of(2016, 5, 20));


        Appointment walApp = new Appointment("cse308examWal", "cse_308", "wal", LocalDateTime.of(2015, 10,29, 1, 0),
                LocalDateTime.of(2015,10,29,2,20),"wal", "5R13", false);

        Appointment yimApp = new Appointment("cse308examYim", "cse_308", "yim", LocalDateTime.of(2015,10,30, 1, 0),
                LocalDateTime.of(2015,10,30,2,20),"yim", "5R15", false);

        Appointment zeqApp = new Appointment("cse308examZeq", "cse_308", "zeq", LocalDateTime.of(2016,1,30, 1, 0),
                LocalDateTime.of(2015,1,31,2,20),"yim", "5R15", false);

        Appointment yisApp = new Appointment("cse308examYis", "cse_219", "yis", LocalDateTime.of(2015,10,30, 1, 0),
                LocalDateTime.of(2015,12,17,2,20),"yim", "5R15", false);

        addAppointment(walApp);
        addAppointment(yimApp);
        addAppointment(yisApp);
        addAppointment(zeqApp);

        Report report = new Report();
        report.showDayReport(term1);
        report.showWeekReport(term1);

        Exam exam1 = new Exam("308","software","ad hoc", LocalDateTime.of(2015,9,20,13,30),LocalDateTime.of(2015,9,21,15,0), 1.5,50,80);
        Exam exam2 = new Exam("305","system","course", LocalDateTime.of(2015,9,20,15,10),LocalDateTime.of(2015,9,21,17,40), 2.5,50,80);
        ExamDao exam = new ExamDaoImp();
        exam.addExam(exam1);
        exam.addExam(exam2);

        report.showTermReport(term1);

        List<Term> terms = new LinkedList<>();
        terms.add(term1);
        terms.add(term2);
        terms.add(term3);
        report.showTermRangeReport(terms);

    }

    // Insert a row into Administrator Table
    public static void addAppointment(Appointment appt){
        Session session = SessionManager.getInstance().getOpenSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(appt);
            System.out.println("---------- addAppointment(Appointment appt) ----------");
            System.out.println("|  -AppointmentID" + appt.getAppointmentID());
            System.out.println("|  -EmailId" + appt.getExamId());
            System.out.println("|  -MadeBy" + appt.getMadeBy());
            System.out.println("|  -StartDateTime" + appt.getStartDateTime());
            System.out.println("|  -EndDateTime" + appt.getEndDateTime());
            System.out.println("|  -StudentId" + appt.getStudentId());
            System.out.println("|  -Seat" + appt.getSeat());
            System.out.println("|  -IsAttended" + appt.isAttend());

            tx.commit();
            session.close();
        }catch (HibernateException he){
            he.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
        }
    }
}
