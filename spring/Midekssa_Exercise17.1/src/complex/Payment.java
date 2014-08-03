package complex;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Payment {
	@Id
	@GeneratedValue
	private int id;
	private String payDate;
	private double amount;

	public Payment() {
	}

	public Payment(String payDate, double amount) {
		this.payDate = payDate;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(int id) {
		this.id = id;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
