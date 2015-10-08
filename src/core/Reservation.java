package core;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Reservation")
public class Reservation {

    @Id
    private String ReservationID;
    @Temporal(TemporalType.TIME)
    @Column(name="startTime")
    private LocalTime startTime;
    @Temporal(TemporalType.TIME)
    @Column(name="endTime")
    private LocalTime endTime;
    @Temporal(TemporalType.DATE)
    @Column(name="startDate")
    private LocalDate startDate;
    @Temporal(TemporalType.DATE)
    @Column(name="endDate")
    private LocalDate endDate;
    @Column(name="duration")
    private int duration;
    @Column(name="instructorName")
    private String instructorName;
    @Column(name="attendence")
    private int attendence;
    //haven't initiated
    @Column(name="status")
    private Status status;

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public int getAttendence() {
        return attendence;
    }

    public void setAttendence(int attendence) {
        this.attendence = attendence;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
