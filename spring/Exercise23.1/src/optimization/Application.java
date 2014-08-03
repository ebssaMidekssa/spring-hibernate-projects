package optimization;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hsqldb.lib.StopWatch;

public class Application {
	private static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure()
				.buildSessionFactory();
	}

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			for (int x = 0; x < 1000; x++) {
				Owner owner = new Owner("Frank" + x);
				List<Pet> petlist = new ArrayList<Pet>();
				for (int y = 0; y < 10; y++) {
					Pet pet = new Pet("Garfield" + x + "-" + y);
					petlist.add(pet);
				}
				owner.setPets(petlist);
				session.persist(owner);
			}

			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		// start the stopwatch
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Owner.class);
			@SuppressWarnings("unchecked")
			List<Owner> ownerlist = criteria.list();
			for (Owner owner : ownerlist) {
				for (Pet pet : owner.getPets()) {
					System.out.println("Owner name= " + owner.getName()
							+ "pet name= " + pet.getName());
				}
			}
			
			tx.commit();

		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		// stop the stopwatch
		stopwatch.stop();
		System.out.println("To fetch this data from the database took "
				+ stopwatch.elapsedTime() + "milliseconds.");
	}

}
