package core.user;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Administrator")
public class Administrator extends UserType {
    @Basic(optional = false)
    public final static Authorization authLevel = Authorization.ADMINISTRATOR;

}
