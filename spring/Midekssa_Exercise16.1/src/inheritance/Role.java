package inheritance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Role {
    private long id;
    private Date start;
   	private Date stop;
    private Person owner;
} // end Role class

