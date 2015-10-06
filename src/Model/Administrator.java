package Model;

import javax.persistence.Entity;

@Entity
public class Administrator extends UserType{
    private Authorization authLevel;
}
