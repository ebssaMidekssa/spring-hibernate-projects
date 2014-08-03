package associations.xml;


import java.util.ArrayList;
import java.util.Collection;

public class Customer {
	private int id;
	private String name;
	private Collection<Reservation> reservations = new ArrayList<Reservation>();

	public Customer() {
		super();
	}

	public Customer(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void addReservation(Reservation reservation) {
		reservations.add(reservation);
	}

	public String toString() {
		String res = "";
		for (Reservation reservation : reservations) {
			res = res +"\n\t\t" + reservation;
			
		}

		return this.name + "\t" + res;
	}
}
