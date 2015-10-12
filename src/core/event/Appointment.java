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
    private String AppointmentID;

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
    private String StudentName;

    public String getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        AppointmentID = appointmentID;
    }

    public LocalDateTime getStartDateTime() {
        return converterDToLdt(startDateTime);
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = converterLdtToD(startDateTime);
    }

    public LocalDateTime getEndDateTime() {
        return converterDToLdt(endDateTime);
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = converterLdtToD(endDateTime);
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public UserType getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(UserType madeBy) {
        this.madeBy = madeBy;
    }

    // Below are help methods to convert LocalDateTime and Date interchange
    private Date converterLdtToD(LocalDateTime dateTime){
        Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date res = Date.from(instant);
        return res;
    }

    private LocalDateTime converterDToLdt(Date date){
        Instant instant = Instant.ofEpochMilli(date.getTime());
        LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return res;
    }


}
