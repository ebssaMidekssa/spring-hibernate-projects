package inheritance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue
   	private long id;
    private String name;
    private String phone;
    private String email;
    private List<Role> roles = new ArrayList<Role>();
} // end person class
