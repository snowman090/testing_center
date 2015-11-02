package core.event;

import core.user.Instructor;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import java.time.*;
import java.util.Date;

@Entity
@Table(name="Reservation")
public class Reservation {
    @Id
    @Column(name = "reservation_id")
    @Basic(optional = false)
    private String reservationID;

    @Temporal(TemporalType.TIME)
    @Column(name="start_time")
    @Basic(optional = false)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="start_date_time")
    @Basic(optional = false)
    private Date startDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end_date_time")
    @Basic(optional = false)
    private Date endDateTime;

    private int duration;

    @Column(name="instructor_id")
    @Basic(optional = false)
    private String instructorId;


    //haven't initiated
    @Basic(optional = false)
    @Column(name="status")
    private Status status;



    public Date getStartTime() {// for ReservationDaoImp
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }


    //---------------------------------------
    public LocalDateTime getStartDateTime() {
        Date ts = startDateTime;
        Instant instant = Instant.ofEpochMilli(ts.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        Instant instant = startDateTime.atZone(ZoneId.systemDefault()).toInstant();
        this.startDateTime = Date.from(instant);
    }

    public LocalDateTime getEndDateTime() {
        Date ts = endDateTime;
        Instant instant = Instant.ofEpochMilli(ts.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        Instant instant = endDateTime.atZone(ZoneId.systemDefault()).toInstant();
        this.endDateTime = Date.from(instant);
    }
    //---------------------------------------
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }


    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }
    public String getReservationID() {
        return reservationID;
    }


    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorId() {
        return instructorId;
    }


    public void setStatus(Status status) {
        this.status = status;
    }
    public Status getStatus() {
        return status;
    }



    // Extend functionality
    public LocalDate getStartDate(){
        Instant instant = Instant.ofEpochMilli(startDateTime.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }
    public LocalDate getEndDate(){
        Instant instant = Instant.ofEpochMilli(endDateTime.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
    }
}
