package core.user;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Administrator")
public class Administrator extends UserType {
    @Basic(optional = false)
    public final static Authorization authLevel = Authorization.ADMINISTRATOR;

    // Empty Constructor for Hibernate
    public Administrator() {
    }

    public Administrator(String netId, String pwd, String firstName, String lastName) {
        this.netId = netId;
        this.password = pwd;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //static final authLevel is already initialized
    /**
    static {
        authLevel = Authorization.ADMINISTRATOR;
    }*/
}
