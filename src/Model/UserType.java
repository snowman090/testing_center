package Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "USER_TYPE")
public class UserType {
    @Id
    private String netId;
    private String firstName;
    private String lastName;
    private Authorization authLevel;

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

    public Authorization getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(Authorization authLevel) {
        this.authLevel = authLevel;
    }
}
