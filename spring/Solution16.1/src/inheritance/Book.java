package inheritance;

import javax.persistence.Entity;

@Entity
public class Book extends Product {
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
