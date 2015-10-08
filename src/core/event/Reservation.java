package core.event;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Reservation")
public class Reservation {
    @Id
    @Column(name = "RESERVATIONID")
    @Basic(optional = false)
    private String ReservationID;
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
    private String instructorName;
    @Column(name="ATTENDANCE")
    private int attendence;
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
