package Model;

import javax.persistence.*;

@Entity
@MappedSuperclass
@Table(name = "USER_TYPE")
public abstract class UserType {
    @Id
    private String netId;
    private String firstName;
    private String lastName;

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

}
