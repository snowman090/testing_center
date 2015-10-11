package core.controller;


import core.event.Appointment;
import core.event.AppointmentDao;
import core.event.AppointmentDaoImpl;
import core.event.TestingCenterInfo;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class Utilization {

    private long utilzExpection;
    private long utilzActual;
    private int numApprove;
    private int numStudent;
    private int numDay;
    private int gap;
    private int day;
    private String exam;
    private int numSeat;
///
    TestingCenterInfo center = new TestingCenterInfo();
    AppointmentDao appointmentDao = (AppointmentDao) new AppointmentDaoImpl();



    public long countUtilzActual(){
        long TotalDuration = 0;
        long Hours = ChronoUnit.HOURS.between(center.getOpen(), center.getClose());////
        for (Appointment appointment : appointmentDao.findAllAppointment()) {
            TotalDuration += ChronoUnit.HOURS.between(appointment.getStartDateTime(), appointment.getEndDateTime())
        }
        utilzActual = TotalDuration / (numSeat * Hours);
    }

    public long countUtilzExpection(){
        long TotalDuration = 0;
        long Hours = ChronoUnit.HOURS.between(center.getOpen(), center.getClose());////
        for (Appointment appointment : appointmentDao.findAllAppointment()) {
            TotalDuration += ChronoUnit.HOURS.between(appointment.getStartDateTime(), appointment.getEndDateTime())
        }
        utilzActual = TotalDuration / (numSeat * Hours);
    }

    public int getUtilzExpection() {
        return utilzExpection;
    }

    public void setUtilzExpection(int utilzExpection) {
        this.utilzExpection = utilzExpection;
    }

    public int getUtilzActual() {
        return utilzActual;
    }

    public void setUtilzActual(int utilzActual) {
        this.utilzActual = utilzActual;
    }

    public int getNumApprove() {
        return numApprove;
    }

    public void setNumApprove(int numApprove) {
        this.numApprove = numApprove;
    }

    public int getNumStudent() {
        return numStudent;
    }

    public void setNumStudent(int numStudent) {
        this.numStudent = numStudent;
    }

    public int getNumDay() {
        return numDay;
    }

    public void setNumDay(int numDay) {
        this.numDay = numDay;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public int getNumSeat() {
        return numSeat;
    }

    public void setNumSeat(int numSeat) {
        this.numSeat = numSeat;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }
}
