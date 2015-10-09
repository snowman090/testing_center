package core.user;

import core.event.Appointment;
import core.user.Authorization;
import core.user.UserType;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "UserType")
public class Student extends UserType {
    public static final Authorization permission;
    private List<Appointment> appointments;

    // Empty Constructor for Hibernate
    public Student() {
    }

    public Student(String netId, String pwd, String firstName, String lastName) {
        this.netId = netId;
        this.password = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    static {
        permission = Authorization.STUDENT;
    }
}
