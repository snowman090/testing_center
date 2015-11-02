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


public class ReportTest {

    public static void main(String[] args){
        Term term = new Term();
        term.setTermId(1158);
        term.setTermStartDate(LocalDate.of(2015, 8, 22));
        term.setTermEndDate(LocalDate.of(2015, 12, 17));


        Appointment walApp = new Appointment("cse308examWal", "cse_308", "wal", LocalDateTime.of(2015, 10,29, 1, 0),
                LocalDateTime.of(2015,10,29,2,20),"wal", "5R13", false);
        Student wal = new Student("wal", "aaa", "wal", "wu", "walt.wu@gmail.com");

        Appointment yimApp = new Appointment("cse308examYim", "cse_308", "yim", LocalDateTime.of(2015,10,30, 1, 0),
                LocalDateTime.of(2015,10,30,2,20),"yim", "5R15", false);

        Appointment yisApp = new Appointment("cse308examYis", "cse_219", "yis", LocalDateTime.of(2015,10,30, 1, 0),
                LocalDateTime.of(2015,12,17,2,20),"yim", "5R15", false);

        addAppointment(walApp);
        addAppointment(yimApp);
        addAppointment(yisApp);

        Report report = new Report();
        report.showDayReport(term);
        report.showWeekReport(term);

        Exam exam1 = new Exam("308","software","ad hoc", LocalDateTime.of(2015,9,20,13,30),LocalDateTime.of(2015,9,21,15,0), 1.5,50,80);
        Exam exam2 = new Exam("305","system","course", LocalDateTime.of(2015,9,20,15,10),LocalDateTime.of(2015,9,21,17,40), 2.5,50,80);
        ExamDao exam = new ExamDaoImp();
        exam.addExam(exam1);
        exam.addExam(exam2);

        report.showTermReport(term);

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
