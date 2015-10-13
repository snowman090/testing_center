package test;

import core.db.SessionManager;
import core.event.Appointment;
import core.event.DataCollection;
import core.event.TestingCenterInfo;
import core.user.Administrator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Zeqli on 10/12/2015.
 */
public class UnitTest {

    private static SessionManager sessionManager;
    public static final Logger log = Logger.getLogger(Log4J.class);

    public static void main(String[] args) {


        UnitTest ut = new UnitTest();
        Administrator admin1 = new Administrator("zeqli", "abc","zeq", "li", "gmail");
        Administrator admin2 = new Administrator("yiminz", "abc","yimin", "zhu", "gmail");
        Administrator admin3 = new Administrator("walt", "abc","walt", "wu", "gmail");
        ut.addAdmin(admin1);
        ut.addAdmin(admin2);
        ut.addAdmin(admin3);
        ut.listAdmins();

        exam exam1 = new exam("308","software","ad hoc", LocalDateTime.of(2015,6,20,10,30),LocalDateTime.of(2015,6,20,15,0), 4.5,50,80);
        exam exam2 = new exam("390","system","course", LocalDateTime.of(2015,6,20,15,10),LocalDateTime.of(2015,6,20,18,40), 2.5,50,80);
        ut.addExam(exam1);
        ut.addExam(exam2);

        ut.listExams();

        //Actual utilization part
        Utilization util = new Utilization();



        util.getCenter().setOpen(LocalDateTime.of(2015,6,20,9, 30));
        util.getCenter().setClose(LocalDateTime.of(2015,6,20,17, 0));

        Appointment appointment1 = new Appointment();
        Appointment appointment2 = new Appointment();//
        appointment1.setStartDateTime(LocalDateTime.of(2015, 6, 20, 10, 30));
        appointment1.setEndDateTime(LocalDateTime.of(2015, 6, 20, 12, 30));
        appointment1.setAppointmentID("1");

        appointment2.setStartDateTime(LocalDateTime.of(2015, 6, 20, 13, 30));
        appointment2.setEndDateTime(LocalDateTime.of(2015, 6, 20, 15, 30));
        appointment2.setAppointmentID("2");

        util.getAppointmentDao().addAppointment(appointment1);
        util.getAppointmentDao().addAppointment(appointment2);



        util.setNumSeat(60);
        ut.viewActualUtilization(util);
        //
        util.setGap(0.25);
        util.setDay(2);
        util.getExamDao().addExam(exam1);
        util.getExamDao().addExam(exam2);
        ut.viewCountUtilzExpection(util);

        admin1.setEmail("zeqing.li@stonybrook.edu");
        ut.updateAdmin(admin1);

        TestingCenterInfo info = new TestingCenterInfo();
        info = ut.viewTestingCenterInfo(info);
        ut.saveTestingCenterInfo(info);

        DataCollection data = new DataCollection();
        ut.importDate("./doc/testcases/user.csv");
    }

    public void addAdmin(Administrator admin){
            Session session = sessionManager.getInstance().getOpenSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(admin);
                log.info("---------- addAdmin(Administrator admin)----------");
                log.info("|  -Administrator Id: " + admin.getNetId());
                log.info("|  -Password: " + admin.getPassword());
                log.info("|  -First Name: " + admin.getFirstName());
                log.info("|  -Last Name" + admin.getLastName());
                log.info("|  -Email" + admin.getEmail());
                tx.commit();
                session.close();
            }catch (HibernateException he){
                he.printStackTrace();
                if(tx != null){
                    tx.rollback();
                }
            }
    }

    public TestingCenterInfo viewTestingCenterInfo(TestingCenterInfo info){
        info = TestingCenterInfo.deserialize();
        log.info("---------- viewTestingCenterInformation ----------");
        log.info("|  -Number of Seat: " + info.getNumSeats());
        log.info("|  -Number of Set-Aside-Seats: " + info.getNumSetAsideSeats());
        log.info("|  -Open Hour: " + info.getOpen());
        log.info("|  -Close Hour: " + info.getClose());
        Iterator<LocalDateTime[]> it = (info.getCloseDateRanges().iterator());
        while(it.hasNext()){
            LocalDateTime[] item = it.next();
            log.info("|  -Close Date Range: " + item[0]+ " " + item[1]);
        }
        Iterator<LocalDateTime[]> it2 = (info.getReserveRanges().iterator());
        while(it2.hasNext()){
            LocalDateTime[] item = it2.next();
            log.info("|  -Reserve Date Time Range: " + item[0] + " " + item[1]);
        }
        log.info("|  -Gap Time: " + info.getGap());
        log.info("|  -Reminder Interval: " + info.getReminderInterval());
        return info;
    }
    // SQL VIEW
    public void listAdmins() {
        Session session = sessionManager.getInstance().getOpenSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List e = session.createQuery("FROM Administrator").list();
            Iterator iterator = e.iterator();

            while(iterator.hasNext()) {
                Administrator admin = (Administrator)iterator.next();
                log.info("---------- listAdmins()----------");
                log.info("|  -Administrator Id: " + admin.getNetId());
                log.info("|  -Password: " + admin.getPassword());
                log.info("|  -First Name: " + admin.getFirstName());
                log.info("|  -Last Name" + admin.getLastName());
                log.info("|  -Email" + admin.getEmail());
            }

            tx.commit();
        } catch (HibernateException var9) {
            if(tx != null) {
                tx.rollback();
            }

            var9.printStackTrace();
        } finally {
            session.close();
        }

    }

    // SQL UPDATE
    public void updateAdmin(Administrator admin) {
        Session session = sessionManager.getInstance().getOpenSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Administrator e = (Administrator)session.get(Administrator.class, admin.getNetId());
            e.update(admin);
            session.update(e);
            tx.commit();
        } catch (HibernateException var9) {
            if(tx != null) {
                tx.rollback();
            }

            var9.printStackTrace();
        } finally {
            session.close();
        }

    }

    // SQL DELETE
    public void deleteAdmin(String NetId) {
        Session session = sessionManager.getInstance().getOpenSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Administrator e = (Administrator)session.get(Administrator.class, NetId);
            session.delete(e);
            tx.commit();
        } catch (HibernateException var8) {
            if(tx != null) {
                tx.rollback();
            }

            var8.printStackTrace();
        } finally {
            session.close();
        }}

    public void saveTestingCenterInfo(TestingCenterInfo info){
        System.out.println(info.getClose());
        info.update(info);
        log.info("---------- updateviewtestingCenterInformation ----------");
        log.info("|  -Number of Seat: " + info.getNumSeats());
        log.info("|  -Number of Set-Aside-Seats: " + info.getNumSetAsideSeats());
        log.info("|  -Open Hour: " + info.getOpen());
        log.info("|  -Close Hour: " + info.getClose());
        Iterator<LocalDateTime[]> it = (info.getCloseDateRanges().iterator());
        while(it.hasNext()){
            LocalDateTime[] item = it.next();
            log.info("|  -Close Date Range: " + item[0]+ " " + item[1]);
        }
        Iterator<LocalDateTime[]> it2 = (info.getReserveRanges().iterator());
        while(it2.hasNext()){
            LocalDateTime[] item = it2.next();
            log.info("|  -Reserve Date Time Range: " + item[0] + " " + item[1]);
        }
        log.info("|  -Gap Time: " + info.getGap());
        log.info("|  -Reminder Interval: " + info.getReminderInterval());
        info = TestingCenterInfo.deserialize();
        log.info("---------- saveTestingCenterInformation ----------");
        log.info("|  -Number of Seat: " + info.getNumSeats());
        log.info("|  -Number of Set-Aside-Seats: " + info.getNumSetAsideSeats());
        log.info("|  -Open Hour: " + info.getOpen());
        log.info("|  -Close Hour: " + info.getClose());
        Iterator<LocalDateTime[]> it3 = (info.getCloseDateRanges().iterator());
        while(it.hasNext()){
            LocalDateTime[] item = it3.next();
            log.info("|  -Close Date Range: " + item[0]+ " " + item[1]);
        }
        Iterator<LocalDateTime[]> it4 = (info.getReserveRanges().iterator());
        while(it2.hasNext()){
            LocalDateTime[] item = it4.next();
            log.info("|  -Reserve Date Time Range: " + item[0] + " " + item[1]);
        }
        log.info("|  -Gap Time: " + info.getGap());
        log.info("|  -Reminder Interval: " + info.getReminderInterval());
    }

    public void importDate(String path){
        DataCollection data = new DataCollection();
        data.readFile(path);
    }

    public void adminMakeApptForStudentTestCase(){


    }

    public void adminViewApptForASpecificTimeTestCase(){

    }

    public void adminCancelApptTestCase(){

    }

    public void adminEditApptTestCase(){

    }

    public void checkinStudentTestCase(){

    }

    public void addExam(exam exam){
        Session session = sessionManager.getInstance().getOpenSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(exam);
            log.info("---------- add Exam info----------");
            log.info("|  -Exam Id: " + exam.getExamId());
            log.info("|  -Exam Name: " + exam.getExamName());
            log.info("|  -Type: " + exam.getType());
            log.info("|  -Start Date Time: " + exam.getStartDateTime());
            log.info("|  -End Date Time" + exam.getEndDateTime());
            log.info("|  -Duration: " + exam.getDuration());
            log.info("|  -Number of Students who has appointments: " + exam.getNumStudentAppointment());
            log.info("|  -Number of Students who need to take exam: " + exam.getNumStudentNeed());

            tx.commit();
            session.close();
        }catch (HibernateException he){
            he.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
        }
    }
    public void listExams() {
        Session session = sessionManager.getInstance().getOpenSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List e = session.createQuery("FROM exam").list();
            Iterator iterator = e.iterator();

            while(iterator.hasNext()) {
                exam exam = (exam)iterator.next();
                log.info("---------- View Exams()----------");
                log.info("|  -Exam Id: " + exam.getExamId());
                log.info("|  -Exam Name: " + exam.getExamName());
                log.info("|  -Type: " + exam.getType());
                log.info("|  -Start Date Time: " + exam.getStartDateTime());
                log.info("|  -End Date Time" + exam.getEndDateTime());
                log.info("|  -Duration: " + exam.getDuration());
                log.info("|  -Number of Students who has appointments: " + exam.getNumStudentAppointment());
                log.info("|  -Number of Students who need to take exam: " + exam.getNumStudentNeed());
            }

            tx.commit();
        } catch (HibernateException var9) {
            if(tx != null) {
                tx.rollback();
            }

            var9.printStackTrace();
        } finally {
            session.close();
        }
    }
    public void viewActualUtilization(Utilization util){
        log.info("---------- View Actual Utilization----------");
        log.info("|  -Actual Utilization-: " + util.countUtilzActual()+"%");
        log.info("---------- View Actual Utilization----------");
    }

    public void viewCountUtilzExpection(Utilization util){
        log.info("---------- View Expected Utilization----------");
        log.info("|  -Expected Utilization-: " + util.countUtilzExpection()+"%");
        log.info("---------- View Expected Utilization----------");
    }
}
