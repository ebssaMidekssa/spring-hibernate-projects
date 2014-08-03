package inheritance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order {
	@Id
	@GeneratedValue
	private long id;
	private String ordernr;
	private String date;
	private String status;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	private Customer customer;

	@OneToMany(cascade = { CascadeType.PERSIST })
	private Collection<OrderLine> orderlines = new ArrayList<OrderLine>();

	public Order() {
	}

	public Order(String ordernr, String date, String status) {
		this.ordernr = ordernr;
		this.date = date;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public String getOrdernr() {
		return ordernr;
	}

	public void setOrdernr(String ordernr) {
		this.ordernr = ordernr;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<OrderLine> getOrderlines() {
		return Collections.unmodifiableCollection(orderlines);
	}

	@SuppressWarnings("unused")
	private void setOrderlines(Collection<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}

	public boolean addOrderLine(OrderLine ol) {
		return orderlines.add(ol);
	}

}
