package associations.xml;

public class Employee {
	private int employeenumber;
	private String name;
	private Office office;

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public int getEmployeenumber() {
		return employeenumber;
	}

	public void setEmployeenumber(int employeenumber) {
		this.employeenumber = employeenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

}
