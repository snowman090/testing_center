package core.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

//@Table( name = "UserTypes")
//@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class UserType {
    @Id
    @Column(name = "net_id")
    protected String netId;

    @Basic(optional = false)
    @Column(name = "password")
    protected String password;

    @Basic(optional = false)
    @Column(name = "first_name")
    protected String firstName;

    @Basic(optional = false)
    @Column(name = "last_name")
    protected String lastName;

    @Basic(optional = false)
    @Column(name = "email")
    protected String email;

    @Basic(optional = false)
    @Column(name = "student_permission")
    protected Authorization studentPermission;

    @Basic(optional = false)
    @Column(name = "instructor_permission")
    protected Authorization instructorPermission;

    @Basic(optional = false)
    @Column(name = "Administor_permission")
    protected Authorization administorPerssion;

    public UserType()
    {
    }

    public String getNetId() {
        return netId;
    }

    public void setNetId(String netId) {
        this.netId = netId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
