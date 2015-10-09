package core.user;

import core.user.Authorization;
import core.user.UserType;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Administrator")
public class Administrator extends UserType {
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

    static {
        authLevel = Authorization.ADMINISTRATOR;
    }
}
