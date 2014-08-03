package inheritance;

import javax.persistence.Entity;

@Entity
public class DVD extends Product {
	private String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}
