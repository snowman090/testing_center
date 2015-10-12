package test;

import core.db.SessionManager;
import core.event.Appointment;
import core.user.Administrator;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Zeqli on 10/12/2015.
 */
public class UnitTest {

    private static SessionManager sessionManager;
    public static final Logger log = Logger.getLogger(Log4J.class);

    public static void main(String[] args) {


        UnitTest ut = new UnitTest();
        Administrator admin = new Administrator("zeqli", "abc","zeq", "li", "zeqli");

    }

    public void addAdmin(Administrator admin){
            Session session = sessionManager.getInstance().getOpenSession();
            Transaction tx = null;
            Appointment appt = null;
            try {
                tx = session.beginTransaction();
                session.save(admin);
                log.info("---------- getAppointment(String apptId)----------");
                log.info("|  -Appointment Id: " + admin.getNetId());
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

}
