package core;

import javax.persistence.Entity;

@Entity
public class Administrator extends UserType{
    public final static Authorization authLevel = Authorization.ADMINISTRATOR;
}
