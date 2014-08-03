package hibernate;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {
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

			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
			Laptop laptop1 = new Laptop("Apple", "iBook", df.parse("04/17/2006"));
			Laptop laptop2 = new Laptop("IBM", "t60", df.parse("03/30/07"));

			session.persist(laptop1);
			session.persist(laptop2);

			tx.commit();
		} catch (Exception e) {
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
			List<Laptop> laptops = session.createQuery("from Laptop").list();
			for (Laptop laptop : laptops) {
				System.out.println(laptop.getBrand() + " " + laptop.getModel()
						+ " " + laptop.getPurchase_date());
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
