package core.user;

import core.db.SessionManager;
import core.event.Appointment;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.*;
import test.Log4J;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "Administrator")
public class Administrator extends UserType {

    private static SessionManager sessionManager;
    public static final Logger log = Logger.getLogger(Log4J.class);

    @Basic(optional = false)
    public final static Authorization authLevel = Authorization.ADMINISTRATOR;

    // Empty Constructor for Hibernate
    public Administrator() {
    }

    public Administrator(String netId, String pwd, String firstName, String lastName) {
        this.netId = netId;
        this.password = pwd;
        this.firstName = firstName;
        this.lastName = lastName;

    }



    // The system displays all appointments and the number of available
    // seats at the current time or a specified other time.

    public List listAllAppointments(LocalDateTime ldt){
        Session session = sessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        List appointments = null;
        try {
            tx = session.beginTransaction();

            // USE SQL script
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String sql = "select * from appointment where '" + ldt.format(formatter) + "' > startDateTime AND '" + ldt.format(formatter) + "' < endDateTime ";
            log.info("---------- listAllAppointments()----------");
            log.info("- SQL script = " + sql);
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Appointment.class);
            appointments = query.list();

            Iterator it = appointments.iterator();
            while(it.hasNext()){
                Appointment appointment = (Appointment) it.next();
                log.info("| Appointment: ");
                log.info("|  -Appointment Id: " + appointment.getAppointmentID());
                log.info("|  -Start Time: " + appointment.getStartDateTime());
                log.info("|  -End Time: " + appointment.getEndDateTime());
                log.info("|  -Student Name" + appointment.getStudentName());
            }

            tx.commit();
            session.close();
        }catch (HibernateException he){
            he.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
        }
        return appointments;
    }



    // 1. Delete Appointment
    // 2. Release Seats
    public void CancelAppointment(String apptId){
        Session session = sessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Appointment appt = (Appointment)session.get(Appointment.class, apptId);


            log.info("---------- CancelAppointment(String apptId)----------");
            log.info("| Appointment: ");
            log.info("|  -Appointment Id: " + appt.getAppointmentID());
            log.info("|  -Start Time: " + appt.getStartDateTime());
            log.info("|  -End Time: " + appt.getEndDateTime());
            log.info("|  -Student Name" + appt.getStudentName());

            session.delete(appt);
            tx.commit();
            session.close();
        }catch (HibernateException he){
            he.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
        }
        // TestingCenterInfo.releaseSeat(appt)
    }

    // GET APPOINTMENT
    public Appointment getAppointment(String apptID){
        Session session = sessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        Appointment appt = null;
        try {
            tx = session.beginTransaction();
            appt = (Appointment)session.get(Appointment.class, apptID);


            log.info("---------- getAppointment(String apptId)----------");
            log.info("|  -Appointment Id: " + appt.getAppointmentID());
            log.info("|  -Start Time: " + appt.getStartDateTime());
            log.info("|  -End Time: " + appt.getEndDateTime());
            log.info("|  -Student Name" + appt.getStudentName());

            tx.commit();
            session.close();
        }catch (HibernateException he){
            he.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
        }
        return appt;
    }

    // Update Edited Appointment
    public void updateAppointment(Appointment appt){
        Session session = sessionManager.getInstance().getOpenSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(appt);

            log.info("---------- updateAppointment(Appointment apptId)----------");
            log.info("|  -Appointment Id: " + appt.getAppointmentID());
            log.info("|  -Start Time: " + appt.getStartDateTime());
            log.info("|  -End Time: " + appt.getEndDateTime());
            log.info("|  -Student Name" + appt.getStudentName());

            tx.commit();
            session.close();
        }catch (HibernateException he){
            he.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
        }
    }

    /**
     * Check�in a student for an appointment.
     * The system records that the student kept the appointment and
     * displays the student�s seat assignment. (Ideally, students would check in
     * by swiping their ID card, but that is beyond the scope of this course project.)
     * @param netId
     */
    public String checkInStudent(String netId){
        Session session = sessionManager.getInstance().getOpenSession();
        Transaction tx = null;

        Student student = null;
        String assignedSeat = "";
        try {
            tx = session.beginTransaction();

            student  = (Student) session.get(Student.class, netId);

            // Mark student as Checked in
            // student.checkedIn()
            // assignedSeat = student.getAssignedSeat();

            System.out.println("---------Check-in Student--------");


            tx.commit();
            session.close();
        }catch (HibernateException he){
            he.printStackTrace();
            if(tx != null){
                tx.rollback();
            }
        }
        return assignedSeat;

    }


    //static final authLevel is already initialized
    /**
    static {
        authLevel = Authorization.ADMINISTRATOR;
    }*/
}
