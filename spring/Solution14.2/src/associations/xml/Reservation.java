package associations.xml;


import java.util.Date;

public class Reservation {
	private int id;
	private Date date;
	private Book book;

	public Reservation() {
		super();
	}

	public Reservation(Date date, Book book) {
		super();
		this.date = date;
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public String toString() {
		String result = "";
		if (getBook() != null) {
			result = book.getTitle() + "\t";
		}
		if (getDate() != null) {
			result = result + getDate().toString();
		}
		return result;
	}
}
