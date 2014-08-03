package hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonApplication {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Person person1 = new Person("Frank", "Brown", new Date());
			Person person2 = new Person("John", "Doe", new Date());

			session.persist(person1);
			session.persist(person2);

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
			List<Person> people = session.createQuery("from Person").list();
			for (Person person : people) {
				System.out.println(person.getFirstname() + " " + person.getLastname()
						+ " " + person.getDateofbirth());
			}

			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
