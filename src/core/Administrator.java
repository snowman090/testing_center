package core;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Administrator")
public class Administrator extends UserType{
    public final static Authorization authLevel = Authorization.ADMINISTRATOR;
}
