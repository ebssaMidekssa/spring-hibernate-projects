package associations.annotations;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BookApplication {
	private static SessionFactory sessionFactory = new Configuration()
			.configure("associations/annotations/hibernate-annotations.cfg.xml")
			.buildSessionFactory();

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Book book = new Book("123432123", "Java Patterns", "Sam Cooke");
			Publisher publisher = new Publisher("Quick books");
			book.setPublisher(publisher);
			session.persist(book);

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
			Collection<Book> bookList = session.createQuery("from Book").list();
			for (Book book : bookList) {
				System.out.println("Book title = " + book.getTitle());
				System.out.println("Publisher  = "
						+ book.getPublisher().getName());

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
