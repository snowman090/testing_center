package core.user;

import core.event.Appointment;
import core.user.Authorization;
import core.user.UserType;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student extends UserType {
    public static final Authorization permission = Authorization.STUDENT;
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

    public List<Appointment> getAppointments(){
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
