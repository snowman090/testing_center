package core;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Calendar;

@Entity
@Table(name = "Appointment")
public class Appointment {

    private UserType madeBy;

    @Id
    private String AppointmentID;
    @Temporal(TemporalType.TIME)
    @Column(name="startTime")
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
