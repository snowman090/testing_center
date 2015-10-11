package core.controller;


import core.event.TestingCenterInfo;

import java.time.temporal.ChronoUnit;

public class Utilization {

    private int utilzExpection;
    private int utilzActual;
    private int numApprove;
    private int numStudent;
    private int numDay;
    private int gap;
    private int day;
    private String exam;
    private int numSeat;

    TestingCenterInfo center = new TestingCenterInfo();

    public double countUtilization(){

        long Hours = ChronoUnit.HOURS.between(center.getTcOpen() , center.getTcClose());
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
