package associations.annotations;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private long studentid;
	private String name;
	@ManyToMany
	@JoinTable(name = "Student_Course")
	Collection<Course> courselist = new ArrayList<Course>();

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

	public Collection<Course> getCourselist() {
		return courselist;
	}

	public void addCourse(Course course) {
		courselist.add(course);
	}

}
