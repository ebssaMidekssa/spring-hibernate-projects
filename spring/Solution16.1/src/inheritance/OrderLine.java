package inheritance;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrderLine {
	@Id
	@GeneratedValue
	private long id;
	private int quantity;

	@OneToOne(cascade = { CascadeType.PERSIST })
	private Product product;

	public OrderLine() {
	}

	public OrderLine(int quantity, Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
