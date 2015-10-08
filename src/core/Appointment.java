package core;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Calendar;

@Entity
@Table(name = "Appointment")
public class Appointment {
    private UserType madeBy;
    private LocalTime startDateTime;
    private LocalTime endDateTime;
    private String AppointmentID;

    @Id
    public String getAppointmentID() {
        return AppointmentID;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="startTime")
    public LocalTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    @Temporal(TemporalType.TIME)
    @Column(name="endTime")
    public LocalTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}
