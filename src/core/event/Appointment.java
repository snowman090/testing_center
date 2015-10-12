package core.event;

import core.user.UserType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
    private LocalDateTime startDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="END_TIME")
    @Basic(optional = false)
    private LocalDateTime endDateTime;

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
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
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
