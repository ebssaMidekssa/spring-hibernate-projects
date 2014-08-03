package associations.xml;

public class Book {
	private int id;
	private String isbn;
	private String title;
	private String author;

	public Book() {
		super();
	}

	public Book(String title, String isbn, String author) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String toString() {
		return this.title + "\t" + this.isbn + "\t" + this.author + "\t";
	}
}
