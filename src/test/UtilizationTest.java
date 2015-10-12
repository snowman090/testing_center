package test;

import core.controller.Utilization;
import core.event.Appointment;

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
        appointment1.setStartDateTime(LocalTime.of(10, 30));
        appointment1.setEndDateTime(LocalTime.of(12, 30));

        appointment2.setStartDateTime(LocalTime.of(13, 30));
        appointment2.setEndDateTime(LocalTime.of(15, 30));

        util.setNumSeat(60);

        util.getAppointmentDao().addAppointment(appointment1);
        util.getAppointmentDao().addAppointment(appointment2);

        System.out.println(util.countUtilzActual());
    }
}
