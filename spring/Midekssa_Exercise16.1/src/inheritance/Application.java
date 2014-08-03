package inheritance;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class Application {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
	}

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Book book = new Book();
			book.setName("Hibernate 3");
			book.setDescription("Good book on Hibernate");
			book.setPrice(35.50);
			book.setTitle("Hibernate in action");
			OrderLine ol1 = new OrderLine(2, book);

			CD cd = new CD();
			cd.setName("The best of Queen");
			cd.setDescription("Album from 1995");
			cd.setPrice(12.98);
			cd.setArtist("Queen");
			OrderLine ol2 = new OrderLine(4, cd);

			Order o1 = new Order("234743", "12/10/06", "open");
			o1.addOrderLine(ol1);
			o1.addOrderLine(ol2);

			Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1",
					"New york", "43221");
			c1.addOrder(o1);

			
			// save the customer -- cascades down
			session.persist(c1);

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

			// retieve all orders
			List<Order> orderList = session.createQuery("from Order").list();
			for (Order order : orderList) {
				printOrder(order);
			}
			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		// Close the SessionFactory (not mandatory)
		sessionFactory.close();
	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrdernr());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstname() + " "
				+ cust.getLastname());
		for (OrderLine orderline : order.getOrderlines()) {
			System.out.println("Order line: quantity= "
					+ orderline.getQuantity());
			Product product = orderline.getProduct();
			System.out.println("Product: " + product.getName() + " "
					+ product.getDescription() + " " + product.getPrice());
			if (product instanceof Book) {
				System.out.println("Book title = "
						+ ((Book) product).getTitle());
			}
			if (product instanceof CD) {
				System.out.println("CD artist = " + ((CD) product).getArtist());
			}
			if (product instanceof DVD) {
				System.out.println("DVD genre = " + ((DVD) product).getGenre());
			}
		}

	}
}
