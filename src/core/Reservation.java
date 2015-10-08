package core;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name="Reservation")
public class Reservation {
    private LocalTime startTime;
    private LocalTime endTime;
    private int duration;
    private String instructorName;
    //haven't initiated
    private Status status;
    private int attendence;
}
