package collections.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private long studentid;
	private String name;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Student_Course")
	Set<Laptop> laptoplist = new HashSet<Laptop>();

	public Student(String name) {
		this.name = name;
	}

	public Student() {
	}

	public long getStudentid() {
		return studentid;
	}

	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Laptop> getLaptoplist() {
		return Collections.unmodifiableSet(laptoplist);
	}

	public boolean addLaptop(Laptop laptop) {
		boolean added = laptoplist.add(laptop);
		if (added) {
			laptop.setStudent(this);
		}
		return added;
	}
	
	public boolean removeLaptop(Laptop laptop) {
		boolean removed = laptoplist.remove(laptop);
		if (removed) {
			laptop.setStudent(null);
		}
		return removed;
	}

}
