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


        log.info("|  -Insert result: " + reservationDao.insertReservation(R1));
        Reservation t1 = reservationDao.findByID("1");
        //
        log.info("|  -Reservation: " + t1.getReservationID());
        log.info("|  -StartDateTime: " + t1.getStartDateTime());
        log.info("|  -EndDateTime: " + t1.getEndDateTime());
        log.info("|  -Instructor Id: " + t1.getInstructorId());
        log.info("|  -Term: " + t1.getTerms());
        log.info("|  -Status " + t1.getStatus());
        log.info("|  -Type: " + t1.getType());
        log.info("|  Here we set the type to be Ad Hoc");
        t1.setType("Ad Hoc");
        log.info("|  -Reservation: " + t1.getReservationID());
        log.info("|  -StartDateTime: " + t1.getStartDateTime());
        log.info("|  -EndDateTime: " + t1.getEndDateTime());
        log.info("|  -Instructor Id: " + t1.getInstructorId());
        log.info("|  -Term: " + t1.getTerms());
        log.info("|  -Status " + t1.getStatus());
        log.info("|  -Type: " + t1.getType());




    }
}
