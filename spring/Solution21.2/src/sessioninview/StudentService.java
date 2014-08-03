package sessioninview;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {
	private StudentDAO studentdao;
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public StudentService() {
		studentdao = new StudentDAO();
	}

	public Student getStudent(long studentid) {
		Transaction tx = sf.getCurrentSession().beginTransaction();
		Student student = studentdao.load(studentid);;
		Hibernate.initialize(student.getCourselist());
		tx.commit();
		return student;
	}
}
