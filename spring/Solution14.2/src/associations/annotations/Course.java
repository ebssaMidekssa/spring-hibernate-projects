package associations.annotations;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private long coursenumber;
	private String name;
	@ManyToMany(mappedBy="courselist", cascade=CascadeType.PERSIST)
	private Collection<Student> studentlist =new ArrayList<Student>();


	public Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public long getCoursenumber() {
		return coursenumber;
	}

	public void setCoursenumber(long coursenumber) {
		this.coursenumber = coursenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Student> getStudentlist() {
		return studentlist;
	}

	public void addStudent(Student student) {
		studentlist.add(student);
	}

}
