package test;

import core.event.Appointment;
import core.event.Exam;
import core.service.SessionManager;
import core.user.Student;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDateTime;

/**
 * This Class Contains Test
 */
public class StudentFunctionalityTest {

    private static SessionManager sessionManager;
    public static final Logger log = Logger.getLogger(Log4J.class);

    public static void main(String[] args){

        StudentFunctionalityTest sf = new StudentFunctionalityTest();

        Exam exam = new Exam("cse_308","course", LocalDateTime.of(2015,10,29,0,0),LocalDateTime.of(2015,10,29, 5,0), 5,50,80);
        Exam exam2 = new Exam("cse_305","course", LocalDateTime.of(2015,6,20,15,10),LocalDateTime.of(2015,10,1,17,40), 2.5,50,80);
        Exam exam3 = new Exam("cse_305_1","course", LocalDateTime.of(2015,8,20,15,10),LocalDateTime.of(2015,9,16,17,40), 2.5,50,80);
        Exam exam4 = new Exam("mat_200","course", LocalDateTime.of(2015,9,29,15,10),LocalDateTime.of(2015,9,30,5,40), 2.5,50,80);
        sf.addExam(exam);
        sf.addExam(exam2);
        sf.addExam(exam3);
        sf.addExam(exam4);

        Student student1 = new Student("zeqli", "abc", "zeqing", "li", "l.caecar@gmail.com");
        sf.addStudent(student1);

//        Appointment appt1 = new Appointment("cse308examZeqli", "cse_308", "admin", LocalDateTime.of(2015, 10, 29, 1, 0),
//                    LocalDateTime.of(2015,10,29,2,30),"zeqli", "5R11", false);
//        sf.makeAppointment(appt1);
//
//        Appointment appt2 = new Appointment("cse308examZeqliFail", "cse_308", "admin", LocalDateTime.of(2015, 8, 1, 1, 0),
//                LocalDateTime.of(2015,8,3,2,20),"zeqli", "5R21", false);
//        sf.makeAppointment(appt2);
//
//        Appointment appt3 = new Appointment("cse305examZeqliSuccess", "cse_305", "admin", LocalDateTime.of(2015, 9, 29, 1, 0),
//                LocalDateTime.of(2015,9,30,2,20),"zeqli", "5R12", false);
//        sf.makeAppointment(appt3);
//
//        //TODO need to add seats for exam
//        Appointment appt4 = new Appointment("cse305examZeqli1", "cse_305_1", "admin", LocalDateTime.of(2015, 8, 28, 1, 0),
//                LocalDateTime.of(2015,9,15,2,20),"zeqli", "5R13", false);
//        sf.makeAppointment(appt4);
//
//        Appointment appt5 = new Appointment("mat200exam", "mat_200", "admin", LocalDateTime.of(2015, 9, 29, 1, 0),
//                LocalDateTime.of(2015,9,30,2,20),"zeqli", "5R14", false);
//        sf.makeAppointment(appt5);
    }

//    public void makeAppointment(Appointment appt){
//        if(appt.checkLegalAppointment()==true){
//            addAppointment(appt);
//            System.out.print("\nSuccess.");
//        }
//        else
//            System.out.print("\nFail.");
//        System.out.print("\n"+appt.getAppointmentID());
//
//    }
//
//    // Insert a row into Appointment Table
//    public void addAppointment(Appointment appt) {
//        Session session = sessionManager.getInstance().getOpenSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            session.save(appt);
//
//            tx.commit();
//            session.close();
//        } catch (HibernateException he) {
//            he.printStackTrace();
//            if (tx != null) {
//                tx.rollback();
//            }
//        }
//
//    }
//
//    public void addStudent(Student student){
//        Session session = sessionManager.getInstance().getOpenSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            session.save(student);
//            tx.commit();
//            session.close();
//        }catch (HibernateException he){
//            he.printStackTrace();
//            if(tx != null){
//                tx.rollback();
//            }
//        }
//    }
//
//    public void addExam(Exam exam){
//        Session session = sessionManager.getInstance().getOpenSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            session.save(exam);
//
//            tx.commit();
//            session.close();
//        }catch (HibernateException he){
//            he.printStackTrace();
//            if(tx != null){
//                tx.rollback();
//            }
//        }
//    }
//}