package users;

import appointments.Appointment;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Student extends UserType{
    List<Appointment> appointments;

}
