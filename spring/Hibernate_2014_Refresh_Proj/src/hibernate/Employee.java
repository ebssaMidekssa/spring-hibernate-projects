package hibernate;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name ="EMPLOYEE")
public class Employee {

	public Employee() {
			}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
	@Column(nullable=true,name="NAME")
	private String name;
	@Column(nullable=true,name="ADDRESS")
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
