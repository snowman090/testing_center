package test;

import core.event.Utilization;
import core.event.Appointment;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by eson_wang on 10/12/15.
 */
public class UtilizationTest {
    public static void main(String[] args){
        Utilization util = new Utilization();


        util.getCenter().setOpen(LocalTime.of(9, 30));
        util.getCenter().setClose(LocalTime.of(17, 0));

        Appointment appointment1 = new Appointment();
        Appointment appointment2 = new Appointment();//
        appointment1.setStartDateTime(LocalDateTime.of(2015,6,20,10,30));
        appointment1.setEndDateTime(LocalDateTime.of(2015, 6, 20, 12, 30));
        appointment1.setAppointmentID("1");

        appointment2.setStartDateTime(LocalDateTime.of(2015, 6, 20, 13, 30));
        appointment2.setEndDateTime(LocalDateTime.of(2015, 6, 20, 15, 30));
        appointment2.setAppointmentID("2");

        util.getAppointmentDao().addAppointment(appointment1);
        util.getAppointmentDao().addAppointment(appointment2);

        util.setNumSeat(60);

        System.out.println(util.countUtilzActual());
    }
}
