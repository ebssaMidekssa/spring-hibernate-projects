package collections.list;

import java.util.Collection;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FlightApplication {
	private static SessionFactory sessionFactory = new Configuration()
			.configure("collections/list/hibernate.cfg.xml").buildSessionFactory();

	public static void main(String[] args) {
		// Hibernate placeholders
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Flight flight1 = new Flight(10034,"Amsterdam", "Boston", new Date());
			Flight flight2 = new Flight(10045,"Amsterdam", "Chicago", new Date());
			Flight flight3 = new Flight(10072,"Chicago", "Paris", new Date());
			Passenger passenger = new Passenger("Frank Brown");
			
			// please note, the order in which they are added here 
			// should also be the order in which they are printed
			passenger.addFlight(flight1);
			passenger.addFlight(flight3);
			passenger.addFlight(flight2);
			
			
			session.persist(passenger);


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
			Collection<Passenger> passengerList = session.createQuery("from Passenger").list();
            for(Passenger passenger : passengerList){
            	System.out.println("passenger name = "+ passenger.getName());
            	for(Flight flight : passenger.getFlightlist()){
            		System.out.println("flight nr= "+ flight.getFlightnumber()+" from= "+flight.getFrom()+" to= "+flight.getTo());
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
