package associations.xml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Office {
	private int id;
	private int roomnumber;
	private String building;
	private List<Employee> employees = new ArrayList<Employee>();

	public Office() {
	}

	public Office(int roomnumber, String building) {
		this.roomnumber = roomnumber;
		this.building = building;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public List<Employee> getEmployees() {
		return Collections.unmodifiableList(employees);
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public boolean addEmployee(Employee employee) {
		boolean added = employees.add(employee);
		if (added) {
			employee.setOffice(this);
		}
		return added;
	}
	
	public boolean removeEmployee(Employee employee) {
		boolean removed = employees.remove(employee);
		if (removed) {
			employee.setOffice(null);
		}
		return removed;
	}
}
