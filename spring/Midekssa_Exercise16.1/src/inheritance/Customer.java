package inheritance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private long id;
	private String firstname;
	private String lastname;
	private String street;
	private String city;
	private String zip;

	@OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "customer")
	private Collection<Order> theOrders = new ArrayList<Order>();

	public Customer() {
	}

	public Customer(String firstname, String lastname, String street,
			String city, String zip) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Collection<Order> getTheOrders() {
		return Collections.unmodifiableCollection(theOrders);
	}

	@SuppressWarnings("unused")
	private void setTheOrders(Collection<Order> theOrders) {
		this.theOrders = theOrders;
	}
	
	public boolean addOrder(Order order) {
		boolean added = theOrders.add(order); 
		if (added) {
			order.setCustomer(this);
		}
		return added;
	}

	public boolean removeOrder(Order order) {
		boolean removed = theOrders.remove(order);
		if (removed) {
			theOrders.remove(order);
		}
		return removed;
	}
}
