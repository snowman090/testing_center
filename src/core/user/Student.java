package core.user;

import core.event.Appointment;
import core.user.Authorization;
import core.user.UserType;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student extends UserType {
    public static final Authorization permission = Authorization.STUDENT;

    @OneToMany(mappedBy = "student")
    private List<Appointment> appointments;

//    private String name;
//    private int student_Id;
    // Edit by Zeqing Li. We don't need them right now

    // Empty Constructor for Hibernate
    public Student() {
    }

    public Student(String netId, String pwd, String firstName, String lastName, String email) {
        this.netId = netId;
        this.password = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getStudent_Id() {
//        return student_Id;
//    }
//
//    public void setStudent_Id(int student_Id) {
//        this.student_Id = student_Id;
//    }
    public List<Appointment> getAppointments(){
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
