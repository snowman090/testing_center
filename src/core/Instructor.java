package core;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Instructor extends UserType{
    public final static Authorization authLevel = Authorization.INSTRUCTOR;

    private List<Appointment> reservations;
}
