package hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Application {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure()
				.buildSessionFactory();
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// Create new instance of Car and set values in it
			Car car1 = new Car("BMW", "SDA231", 30221.00);
			Car car3 = new Car("BMW", "SDA231", 30221.00);
			Car car4 = new Car("BMW", "SDA231", 30221.00);
			Customerr customer1 = new Customerr("ebssa","midekssa");
			Customerr customer2 = new Customerr("ebo","tata");
			session.persist(customer1);
			session.persist(customer2);
			car1.setCustomer(customer1);
			car3.setCustomer(customer2);
			// save the car
			session.persist(car1);
			// Create new instance of Car and set values in it
			Car car2 = new Car("Mercedes", "HOO100", 4088.00);
			// save the car
			session.persist(car3);

			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

//		try {
//			session = sessionFactory.openSession();
//			tx = session.beginTransaction();
//
//			// retieve all cars
//			@SuppressWarnings("unchecked")
//			List<Car> carList = session.createQuery("from Car").list();
//			for (Car car : carList) {
//				System.out.println("brand= " + car.getBrand() + ", year= "
//						+ car.getYear() + ", price= " + car.getPrice());
//			}
//			tx.commit();
//
//		} catch (HibernateException e) {
//			tx.rollback();
//			e.printStackTrace();
//		} finally {
//			if (session != null)
//				session.close();
//		}
//
//		// Close the SessionFactory (not mandatory)
//		sessionFactory.close();
	}
}
