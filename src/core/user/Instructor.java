package core.user;

import core.event.Appointment;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Instructor")
public class Instructor extends UserType {
    @Basic(optional = false)
    public final static Authorization authLevel = Authorization.INSTRUCTOR;

    private List<Appointment> reservations;
}
