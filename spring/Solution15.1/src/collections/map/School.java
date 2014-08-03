package collections.map;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class School {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "student")
	@MapKey(name = "studentid")
	Map<Long, Student> studentmap = new HashMap<Long, Student>();

	public School() {
	}

	public School(String name) {
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

	public Map<Long, Student> getStudentlist() {
		return studentmap;
	}

	public Student addStudent(Student student) {
		return studentmap.put(student.getStudentid(), student);
	}
	
	public Student removeStudent(Student student) {
		return studentmap.remove(student);
	}

}
