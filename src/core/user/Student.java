package core.user;

import core.event.Appointment;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student extends UserType {
    @Basic(optional = false)
    public static final Authorization permission = Authorization.STUDENT;

    private List<Appointment> appointments;

}
