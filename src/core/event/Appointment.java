package core.event;

import core.user.UserType;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "Appointment")
public abstract class Appointment {
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
    private LocalTime startDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="END_TIME")
    @Basic(optional = false)
    private LocalTime endDateTime;

    @Column(name="STUDENT_NAME")
    @Basic(optional = false)
    private String StudentName;

    public String getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        AppointmentID = appointmentID;
    }

    public LocalTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalTime endDateTime) {
        this.endDateTime = endDateTime;
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
}
