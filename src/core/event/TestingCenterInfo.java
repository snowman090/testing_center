package core.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestingCenterInfo {
    private int numSeats;
    private int numSetAsideSeats;
    private LocalTime tcOpen;
    private LocalTime tcClose;//
    private LocalDate tcCloseBeginDate;
    private LocalDate tcCloseEndDate;
    private LocalDateTime ETSExamBegin;
    private LocalDateTime ETSExamEnd;
    private int gap;
    private int reminderInterval;


    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public int getNumSetAsideSeats() {
        return numSetAsideSeats;
    }

    public void setNumSetAsideSeats(int numSetAsideSeats) {
        this.numSetAsideSeats = numSetAsideSeats;
    }

    public LocalTime getTcOpen() {
        return tcOpen;
    }

    public void setTcOpen(LocalTime tcOpen) {this.tcOpen = tcOpen;}

    public LocalTime getTcClose() {return tcClose;}

    public void setTcClose(LocalTime tcClose) {
        this.tcClose = tcClose;
    }

    public LocalDate getTcCloseBeginDate() {
        return tcCloseBeginDate;
    }

    public void setTcCloseBeginDate(LocalDate tcCloseBeginDate) {
        this.tcCloseBeginDate = tcCloseBeginDate;
    }

    public LocalDate getTcCloseEndDate() {
        return tcCloseEndDate;
    }

    public void setTcCloseEndDate(LocalDate tcCloseEndDate) {
        this.tcCloseEndDate = tcCloseEndDate;
    }

    public LocalDateTime getETSExamBegin() {
        return ETSExamBegin;
    }

    public void setETSExamBegin(LocalDateTime ETSExamBegin) {
        this.ETSExamBegin = ETSExamBegin;
    }

    public LocalDateTime getETSExamEnd() {
        return ETSExamEnd;
    }

    public void setETSExamEnd(LocalDateTime ETSExamEnd) {
        this.ETSExamEnd = ETSExamEnd;
    }

    public int getGap() {
        return gap;
    }

    public void setGap(int gap) {
        this.gap = gap;
    }

    public int getReminderInterval() {
        return reminderInterval;
    }

    public void setReminderInterval(int reminderInterval) {
        this.reminderInterval = reminderInterval;
    }


}
