package core.user;

import core.event.Appointment;
import core.user.Authorization;
import core.user.UserType;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "Instructor")
public class Instructor extends UserType {
    public static final Authorization authLevel;
    private List<Appointment> reservations;

    // Empty Constructor for Hibernate
    public Instructor() { }

    public Instructor(String netId, String pwd, String firstName, String lastName) {
        this.netId = netId;
        this.password = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    static {
        authLevel = Authorization.INSTRUCTOR;
    }
}
