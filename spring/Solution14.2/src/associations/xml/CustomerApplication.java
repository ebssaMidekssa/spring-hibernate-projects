package associations.xml;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerApplication {
	private static SessionFactory sessionFactory = new Configuration()
			.configure("associations/xml/hibernate-xml.cfg.xml").buildSessionFactory();

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Customer customer1 = new Customer("Frank Brown");
			Customer customer2 = new Customer("John Doe");
			
			Book book1 = new Book("Java Programming", "2345321234", "K. Moore");
			Book book2 = new Book("Hibernate in Action", "7632345432", "S Johnson");
			Book book3 = new Book("Spring in Action", "3421234564", "M Jones");
			
			Reservation reservation1 = new Reservation(new Date(), book1);
			Reservation reservation2 = new Reservation(new Date(), book2);
			Reservation reservation3 = new Reservation(new Date(), book3);

			
			customer1.addReservation(reservation1);
			customer1.addReservation(reservation2);

			
			customer2.addReservation(reservation3);
			session.persist(customer1);
			session.persist(customer2);
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
			List<Customer> customerList = session.createQuery("from Customer").list();
            for (Customer customer : customerList) {
                System.out.println(customer);
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
