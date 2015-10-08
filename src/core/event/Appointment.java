package core.event;

import core.user.UserType;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "Appointment")
public class Appointment {
    @Id
    private String AppointmentID;
    @Column(name = "MADE_BY")
    private UserType madeBy;
    @Temporal(TemporalType.TIME)
    @Column(name="START_TIME")
    private LocalTime startDateTime;
    @Temporal(TemporalType.TIME)
    @Column(name="endTime")
    private LocalTime endDateTime;

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
}
