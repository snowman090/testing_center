package core;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Reservation")
public class Reservation {
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private int duration;
    private String instructorName;
    private int attendence;
    //haven't initiated
    private Status status;

    @Temporal(TemporalType.TIME)
    @Column(name="startTime")
    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="endTime")
    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="startDate")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="endDate")
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Column(name="duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Column(name="instructorName")
    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    @Column(name="attendance")
    public int getAttendence() {
        return attendence;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }

    @Column(name="status")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
