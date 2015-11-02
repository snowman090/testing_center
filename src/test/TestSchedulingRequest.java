package test;

import core.user.*;
import core.event.*;
import core.service.*;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Date;

public class TestSchedulingRequest {
    public static final Logger log = Logger.getLogger(Log4J.class);
    public static void main(String[] args){
        //


        Reservation R1 = new Reservation("1", LocalDateTime.of(2015,11,1,10,0), LocalDateTime.of(2015,11,1,14,30),"1", "Fall 2015");
        Reservation R2 = new Reservation("2", LocalDateTime.of(2015,11,2,10,0), LocalDateTime.of(2015,11,1,14,30),"2", "Fall 2015");
        Reservation R3 = new Reservation("3", LocalDateTime.of(2015,11,3,10,0), LocalDateTime.of(2015,11,1,14,30),"3", "Fall 2015");
        Reservation R4 = new Reservation("4", LocalDateTime.of(2015,11,4,10,0), LocalDateTime.of(2015,11,1,14,30),"4", "Fall 2015");
        Reservation R5 = new Reservation("5", LocalDateTime.of(2015,11,5,10,0), LocalDateTime.of(2015,11,1,14,30),"5", "Fall 2015");
        //Reservation R1 = new Reservation("1", LocalDateTime.of(2015,11,1,10,0), LocalDateTime.of(2015,11,1,14,30),"1", "Fall 2015");
        //Reservation R1 = new Reservation("1", LocalDateTime.of(2015,11,1,10,0), LocalDateTime.of(2015,11,1,14,30),"1", "Fall 2015");

        Administrator Admin = new Administrator();
        Instructor Ins = new Instructor();

        ReservationDao reservationDao = new ReservationDaoImp();
        //AdministratorDao administratorDao = new AppointmentDaoImp();
        //System.out.println(reservationDao.insertReservation(R1));

        boolean b1 = reservationDao.insertReservation(R1);
        Reservation t1 = reservationDao.findByID("1");
        String S = reservationDao.getStatus("1");
        String T = reservationDao.getType("1");
        log.info("|  -Insert First Reservation, Insert result: " + b1);
        log.info("|  -Reservation Id: " + t1.getReservationID());
        log.info("|  -StartDateTime: " + t1.getStartDateTime());
        log.info("|  -EndDateTime: " + t1.getEndDateTime());
        log.info("|  -Instructor Id: " + t1.getInstructorId());
        log.info("|  -Term: " + t1.getTerms());
        log.info("|  -Status " + S);
        log.info("|  -Type: " + T);
        log.info("|  Here we set the type to be Ad Hoc");
        reservationDao.setType("1", "Ad Hoc");
        S = reservationDao.getStatus("1");
        T = reservationDao.getType("1");
        log.info("|  -Reservation Id: " + t1.getReservationID());
        log.info("|  -StartDateTime: " + t1.getStartDateTime());
        log.info("|  -EndDateTime: " + t1.getEndDateTime());
        log.info("|  -Instructor Id: " + t1.getInstructorId());
        log.info("|  -Term: " + t1.getTerms());
        log.info("|  -Status " + S);
        log.info("|  -Type: " + T);

        boolean b2 = reservationDao.insertReservation(R2);
        Reservation t2 = reservationDao.findByID("2");
        S = reservationDao.getStatus("2");
        T = reservationDao.getType("2");
        log.info("|  -Insert Second Reservation, Insert result: " + b2);
        log.info("|  -Reservation Id: " + t2.getReservationID());
        log.info("|  -StartDateTime: " + t2.getStartDateTime());
        log.info("|  -EndDateTime: " + t2.getEndDateTime());
        log.info("|  -Instructor Id: " + t2.getInstructorId());
        log.info("|  -Term: " + t2.getTerms());
        log.info("|  -Status " + S);
        log.info("|  -Type: " + T);
        log.info("|  Here we set the status of R2 to be Approved");
        reservationDao.setStatus("2", "Approved");
        S = reservationDao.getStatus("2");
        T = reservationDao.getType("2");
        log.info("|  -Reservation Id: " + t2.getReservationID());
        log.info("|  -StartDateTime: " + t2.getStartDateTime());
        log.info("|  -EndDateTime: " + t2.getEndDateTime());
        log.info("|  -Instructor Id: " + t2.getInstructorId());
        log.info("|  -Term: " + t2.getTerms());
        log.info("|  -Status " + S);
        log.info("|  -Type: " + T);


        boolean b3 = reservationDao.insertReservation(R3);
        Reservation t3 = reservationDao.findByID("3");
        S = reservationDao.getStatus("3");
        T = reservationDao.getType("3");
        log.info("|  -Insert Third Reservation, Insert result: " + b3);
        log.info("|  -Reservation Id: " + t3.getReservationID());
        log.info("|  -StartDateTime: " + t3.getStartDateTime());
        log.info("|  -EndDateTime: " + t3.getEndDateTime());
        log.info("|  -Instructor Id: " + t3.getInstructorId());
        log.info("|  -Term: " + t3.getTerms());
        log.info("|  -Status " + S);
        log.info("|  -Type: " + T);
        log.info("|  Here we set the status of R2 to be Denied");
        reservationDao.setStatus("3", "Denied");
        S = reservationDao.getStatus("3");
        T = reservationDao.getType("3");
        log.info("|  -Reservation Id: " + t3.getReservationID());
        log.info("|  -StartDateTime: " + t3.getStartDateTime());
        log.info("|  -EndDateTime: " + t3.getEndDateTime());
        log.info("|  -Instructor Id: " + t3.getInstructorId());
        log.info("|  -Term: " + t3.getTerms());
        log.info("|  -Status " + S);
        log.info("|  -Type: " + T);


        boolean d1 = reservationDao.deleteReservation(R2);
        t1 = reservationDao.findAll().get(0);
        t2 = reservationDao.findAll().get(1);
        S = reservationDao.getStatus(t1.getReservationID());
        T = reservationDao.getType(t1.getReservationID());
        log.info("|  -Delete Pending request, which Reservation Id is 2 ");
        log.info("|  -Delete Reservation result: " + d1);
        log.info("|  -Then we print out all the left Reservations");
        log.info("|  -Reservation Id: " + t1.getReservationID());
        log.info("|  -StartDateTime: " + t1.getStartDateTime());
        log.info("|  -EndDateTime: " + t1.getEndDateTime());
        log.info("|  -Instructor Id: " + t1.getInstructorId());
        log.info("|  -Term: " + t1.getTerms());
        log.info("|  -Status " + S);
        log.info("|  -Type: " + T);
        S = reservationDao.getStatus(t2.getReservationID());
        T = reservationDao.getType(t2.getReservationID());
        log.info("|  ----------------------------------------------------------------------------");
        log.info("|  -Reservation Id: " + t2.getReservationID());
        log.info("|  -StartDateTime: " + t2.getStartDateTime());
        log.info("|  -EndDateTime: " + t2.getEndDateTime());
        log.info("|  -Instructor Id: " + t2.getInstructorId());
        log.info("|  -Term: " + t2.getTerms());
        log.info("|  -Status " + S);
        log.info("|  -Type: " + T);




    }
}
