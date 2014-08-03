package associations.annotations;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
	private Collection<Employee> employeelist = new ArrayList<Employee>();

	public Department() {

	}

	public Department(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Employee> getEmployeelist() {
		return employeelist;
	}

	@SuppressWarnings("unused")
	private void setEmployeelist(Collection<Employee> employeelist) {
		this.employeelist = employeelist;
	}

	public void addEmployee(Employee employee) {
		employeelist.add(employee);
	}

}
