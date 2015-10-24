package core.event;

import core.user.Instructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Reservation")
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @Basic(optional = false)
    private String reservationID;

    @Temporal(TemporalType.TIME)
    @Column(name="START_TIME")
    @Basic(optional = false)
    private LocalTime startTime;

    @Temporal(TemporalType.TIME)
    @Column(name="END_TIME")
    @Basic(optional = false)
    private LocalTime endTime;

    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE")
    @Basic(optional = false)
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE")
    @Basic(optional = false)
    private LocalDate endDate;

    private int duration;

    @Column(name="INSTRUCTOR_NAME")
    @Basic(optional = false)
    private Instructor instructor;

    @Column(name="ATTENDANCE")
    private int attendance;

    private String instructorName;

    //haven't initiated
    @Basic(optional = false)
    @Column(name="STATUS")
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReservationID() {
        return reservationID;
    }

    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
