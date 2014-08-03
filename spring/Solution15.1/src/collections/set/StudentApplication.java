package collections.set;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentApplication {
	private static SessionFactory sessionFactory = new Configuration()
			.configure("collections/set/hibernate.cfg.xml").buildSessionFactory();

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Student student1 = new Student("Frank Brown");
			Laptop laptop1 = new Laptop("Acer","Aspire");
			Laptop laptop2 = new Laptop("DELL","Studio");
			student1.addLaptop(laptop1); // automatically sets bi-directional association
			student1.addLaptop(laptop2);
			
			session.persist(student1);
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
			Collection<Student> studentList = session.createQuery("from Student").list();
            for(Student student : studentList){
            	System.out.println("student name = "+ student.getName());
            	for(Laptop laptop : student.getLaptoplist()){
            		System.out.println("laptop brand= "+ laptop.getBrand()+" type= "+laptop.getType());
            	}
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
