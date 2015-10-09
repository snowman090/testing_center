package core.user;

import javax.persistence.*;

@Entity
@Table( name = "UserTypes")
public abstract class UserType {
    @Id
    @Column(name = "netId")
    protected String netId;

    @Basic(optional = false)
    @Column(name = "password")
    protected String password;

    @Basic(optional = false)
    @Column(name = "firstName")
    protected String firstName;

    @Basic(optional = false)
    @Column(name = "lastName")
    protected String lastName;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    protected String email;

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
