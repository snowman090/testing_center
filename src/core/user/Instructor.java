package core.user;

import core.event.*;
import core.event.Reservation;
import core.event.ReservationDao;
import core.event.ReservationDaoImp;
import core.user.Authorization;
import core.user.UserType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.persistence.Entity;

@Entity
@Table( name = "Instructor")
public class Instructor extends UserType {
    @Basic(optional = false)
    public static final Authorization authLevel = Authorization.INSTRUCTOR;

    // Comments this because it cause Runtime Error When Hibernate Do Mapping
//
//    @OneToMany(mappedBy = "intructor_id")
//    private List<Reservation> reservations;

    // Empty Constructor for Hibernate
    public Instructor() { }

    public Instructor(String netId, String pwd, String firstName, String lastName, String email) {
        this.netId = netId;
        this.password = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

//    public List<Reservation> getReservations() {
//        return reservations;
//    }
//
//    public void setReservations(List<Reservation> reservations) {
//        this.reservations = reservations;
//    }


}
