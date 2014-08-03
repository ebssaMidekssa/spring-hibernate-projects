package collections.set;

import javax.persistence.*;

@Entity
public class Laptop {
	@Id
	@GeneratedValue
	private long id;
	private String brand;
	private String type;
	@ManyToOne
	private Student student;

	public Laptop() {
	}

	public Laptop(String brand, String type) {
		this.brand = brand;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
