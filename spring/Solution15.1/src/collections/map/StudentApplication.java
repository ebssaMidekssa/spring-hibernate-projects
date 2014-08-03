package collections.map;

import java.util.Collection;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentApplication {
	private static SessionFactory sessionFactory = new Configuration()
			.configure("collections/map/hibernate.cfg.xml").buildSessionFactory();

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Student student1 = new Student(1, "Frank","Brown");
			Student student2 = new Student(2, "John","Doe");
			School school = new School("Happy HighSchool");
			school.addStudent(student1);
			school.addStudent(student2);
			
			session.persist(school);
			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

            @SuppressWarnings("unchecked")
			Collection<School> schoolList = session.createQuery("from School").list();
            for(School school : schoolList){
            	System.out.println("school name = "+ school.getName());
            	for (Map.Entry<Long, Student> enty : school.getStudentlist().entrySet())
                    System.out.println(" key = " +enty.getKey() + " studentname = " + ((Student)enty.getValue()).getFirstname());

            }

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
