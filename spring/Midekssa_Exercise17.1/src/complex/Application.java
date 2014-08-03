package complex;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Application {
	private static SessionFactory sessionFactory = new AnnotationConfiguration()
			.configure().buildSessionFactory();

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Doctor doctor1 = new Doctor("Chirurg", "Frank", "Brown");
			Doctor doctor2 = new Doctor("Nurse", "Mary", "Jones");

			Payment payment1 = new Payment("10-10-2008", 12.50);
			Payment payment2 = new Payment("11-10-2008", 45.00);
			Payment payment3 = new Payment("12-10-2008", 99.60);
			Payment payment4 = new Payment("13-10-2008", 55.80);

			Patient patient1 = new Patient("Jerry Lewis", "34 4th avenue",
					"13221", "New York");
			Patient patient2 = new Patient("Frank Moore", "34 Mainstret",
					"13221", "New York");
			Patient patient3 = new Patient("Sam ruby", "105 N Street", "13221",
					"New York");

			Appointment appointment1 = new Appointment("11-11-2008", patient1,
					payment1, doctor1);
			Appointment appointment2 = new Appointment("12-11-2008", patient2,
					payment2, doctor2);
			Appointment appointment3 = new Appointment("13-11-2008", patient3,
					payment3, doctor2);
			Appointment appointment4 = new Appointment("14-11-2008", patient1,
					payment4, doctor1);

			session.persist(appointment1);
			session.persist(appointment2);
			session.persist(appointment3);
			session.persist(appointment4);

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
