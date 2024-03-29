package flightscheduling;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

import flightscheduling.model.Airline;
import flightscheduling.model.Airplane;
import flightscheduling.model.Airport;
import flightscheduling.model.Flight;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

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

		// fill the database 
		fillDataBase();

		// Flights entering the USA after 08/06/2009
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
					Locale.US);

			@SuppressWarnings("unchecked")
			List<Flight> flights = session.createCriteria(Flight.class)
					.add(Restrictions.gt("arrivalDate", df.parse("08/06/2009")))
					.createCriteria("destination")
					.add(Restrictions.eq("country", "USA")).list();
			System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
					"Arrives:");
			for (Flight flight : flights) {
				System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
						flight.getFlightnr(), flight.getOrigin().getCity(),
						flight.getDepartureDate(), flight.getDepartureTime(),
						flight.getDestination().getCity(), flight
								.getArrivalDate(), flight.getArrivalTime());
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		// Flights with a flightnr containing '2' flying to Tokyo
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Flight> flights = session.createCriteria(Flight.class)
					.add(Restrictions.like("flightnr", "%2%"))
					.createCriteria("destination")
					.add(Restrictions.eq("city", "Tokyo")).list();
			System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
					"Arrives:");
			for (Flight flight : flights) {
				System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
						flight.getFlightnr(), flight.getOrigin().getCity(),
						flight.getDepartureDate(), flight.getDepartureTime(),
						flight.getDestination().getCity(), flight
								.getArrivalDate(), flight.getArrivalTime());
			}
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		// Airlines that fly A380 planes to London
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Criteria airlineCriteria = session.createCriteria(Airline.class);
			Criteria flightCriteria = airlineCriteria.createCriteria("flights");
			@SuppressWarnings("unused")
			Criteria airplaneCirteria = flightCriteria
					.createCriteria("airplane")
					.add(Restrictions.eq("model", "A380"));
			@SuppressWarnings("unused")
			Criteria destinationCriteria = flightCriteria
					.createCriteria("destination")
					.add(Restrictions.eq("city", "London"));
			
			@SuppressWarnings("unchecked")
			List<Airline> airlines = airlineCriteria.list();
			System.out.println("Airlines flying A380's to London: ");
			for (Airline airline : airlines) {
				System.out.println(airline.getName());
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
	public static void fillDataBase() {
		Session session = null;
		Transaction tx = null;

		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Airport ams = new Airport("AMS", "Schiphol", "Amsterdam",
					"The Netherlands");
			Airport lhr = new Airport("LHR", "London Heathrow", "London", "UK");
			Airport fra = new Airport("FRA", "Frankfurt International Airport",
					"Frankfurt", "Germany");
			Airport dtw = new Airport("DTW", "Detroid City", "Detroid", "USA");
			Airport ord = new Airport("ORD", "Chicago O'hare International",
					"Chicago", "USA");
			Airport lax = new Airport("LAX", "Los Angeles International",
					"Los Angeles", "USA");
			Airport jfk = new Airport("JFK", "John F. Kennedy International",
					"New York", "USA");
			Airport nrt = new Airport("NRT", "Narita International Airport",
					"Tokyo", "Japan");
			Airport syd = new Airport("SYD", "Kingsford Smith", "Sydney",
					"Australia");
			Airport sin = new Airport("SIN", "Changi Airport", "Singapore",
					"Singapore");

			Airplane airplane1 = new Airplane("12345", "A380", 519);
			Airplane airplane2 = new Airplane("54321", "747", 416);
			Airplane airplane3 = new Airplane("23451", "A380", 519);
			Airplane airplane4 = new Airplane("43215", "747", 416);
			Airplane airplane5 = new Airplane("34512", "A380", 519);
			Airplane airplane6 = new Airplane("32154", "747", 416);

			Airline airline1 = new Airline("SkyTeam");
			Airline airline2 = new Airline("oneworld");
			Airline airline3 = new Airline("Star Alliance");

			Flight flight1 = new Flight("NW 36", "08/06/2009", "7:10 pm",
					"08/07/2009", "9:00 am", airline1, dtw, ams, airplane1);
			Flight flight2 = new Flight("NW 96", "08/06/2009", "3:05 pm",
					"08/07/2009", "1:45 pm", airline1, nrt, dtw, airplane2);
			Flight flight3 = new Flight("QF 12", "08/05/2009", "10:30 pm",
					"08/07/2009", "6:15 am", airline2, lax, syd, airplane3);
			Flight flight4 = new Flight("QF 21", "08/06/2009", "9:55 pm",
					"08/07/2009", "6:55 am", airline2, syd, nrt, airplane4);
			Flight flight5 = new Flight("UA 944", "08/06/2009", "2:30 pm",
					"08/07/2009", "5:45 am", airline3, ord, fra, airplane5);
			Flight flight6 = new Flight("UA 934", "08/06/2009", "12:59 pm",
					"08/07/2009", "7:30 am", airline3, lax, lhr, airplane6);
			Flight flight7 = new Flight("NW 8445", "08/07/2009", "7:15 am",
					"08/07/2009", "7:40 am", airline1, ams, lhr, airplane1);
			Flight flight8 = new Flight("NW 1689", "08/07/2009", "12:05 pm",
					"08/07/2009", "12:21 pm", airline1, dtw, ord, airplane2);
			Flight flight9 = new Flight("QF 3101", "08/07/2009", "3:00 pm",
					"08/07/2009", "11:39 pm", airline2, lax, jfk, airplane3);
			Flight flight10 = new Flight("QF 4022", "08/07/2009", "11:05 am",
					"08/07/2009", "5:15 pm", airline2, nrt, sin, airplane4);
			Flight flight11 = new Flight("UA 941", "08/07/2009", "12:45 pm",
					"08/07/2009", "2:53 pm", airline3, fra, ord, airplane5);
			Flight flight12 = new Flight("UA 4842", "08/07/2009", "8:10 am",
					"08/07/2009", "10:38 am", airline3, lhr, ams, airplane6);

			session.persist(flight1);
			session.persist(flight2);
			session.persist(flight3);
			session.persist(flight4);
			session.persist(flight5);
			session.persist(flight6);
			session.persist(flight7);
			session.persist(flight8);
			session.persist(flight9);
			session.persist(flight10);
			session.persist(flight11);
			session.persist(flight12);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
