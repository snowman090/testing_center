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
@Table( name = "Instructor")
public class Instructor extends UserType {
    public static final Authorization authLevel = Authorization.INSTRUCTOR;
    private List<Appointment> reservations;

    // Empty Constructor for Hibernate
    public Instructor() { }

    public Instructor(String netId, String pwd, String firstName, String lastName) {
        this.netId = netId;
        this.password = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<Appointment> getReservations() {
        return reservations;
    }

    public void setReservations(List<Appointment> reservations) {
        this.reservations = reservations;
    }

    /*
    static {
        authLevel = Authorization.INSTRUCTOR;
    }*/
}
