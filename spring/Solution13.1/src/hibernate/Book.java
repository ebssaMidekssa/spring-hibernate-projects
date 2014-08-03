package hibernate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Book {

	private int id;
	private String title;
	/**
	 * 
	 */
	@Column
	private String ISBN;
	private String author;
	private double price;
	@Temporal(TemporalType.TIMESTAMP)
	private Date publish_date;

	public Book() {
	}

	public Book(String title, String isbn, String author, double price,
			Date publish_date) {
		this.title = title;
		this.ISBN = isbn;
		this.author = author;
		this.price = price;
		this.publish_date = publish_date;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String isbn) {
		ISBN = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
}
