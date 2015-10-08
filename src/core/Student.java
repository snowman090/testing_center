package core;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Student extends UserType{
    public static final Authorization permission = Authorization.STUDENT;

    private List<Appointment> appointments;

}
