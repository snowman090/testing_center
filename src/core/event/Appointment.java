package core.event;

import core.user.UserType;

import javax.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Entity
@Table(name = "Appointment")
public class Appointment {
    public Appointment(){}
    @Id
    @Column(name = "APPOINTMENT_ID")
    @Basic(optional = false)
    private String appointmentID;

    @Column(name = "MADE_BY")
    @Basic(optional = false)
    private UserType madeBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="START_TIME")
    @Basic(optional = false)
    private Date startDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="END_TIME")
    @Basic(optional = false)
    private Date endDateTime;

    @Column(name="STUDENT_NAME")
    @Basic(optional = false)
    private String studentName;

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public LocalDateTime getStartDateTime() {// date to
        Instant instant = Instant.ofEpochMilli(startDateTime.getTime());
        LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        return res;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        Instant instant = startDateTime.atZone(ZoneId.systemDefault()).toInstant();
        this.startDateTime = Date.from(instant);
    }



    public LocalDateTime getEndDateTime() {
        Instant instant = Instant.ofEpochMilli(endDateTime.getTime());
        LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        return res;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        Instant instant = endDateTime.atZone(ZoneId.systemDefault()).toInstant();
        this.endDateTime = Date.from(instant);
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public UserType getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(UserType madeBy) {
        this.madeBy = madeBy;
    }


}
