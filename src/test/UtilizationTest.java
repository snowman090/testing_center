package test;

import core.event.Utilization;
import core.event.Appointment;
import core.event.exam;

import java.time.LocalDateTime;
import java.time.LocalTime;


public class UtilizationTest {
    public static void main(String[] args){

        exam exam1 = new exam("308","software","ad hoc", LocalDateTime.of(2015,6,20,10,30),LocalDateTime.of(2015,6,20,15,0), 4.5,50,80);
        exam exam2 = new exam("390","system","course", LocalDateTime.of(2015,6,20,15,10),LocalDateTime.of(2015,6,20,18,40), 2.5,50,80);
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

        //
        util.setGap(0.25);
        util.setDay(2);
        util.getExamDao().addExam(exam1);
        util.getExamDao().addExam(exam2);
        System.out.println(util.countUtilzExpection());
    }
}
