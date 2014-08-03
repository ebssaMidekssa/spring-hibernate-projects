package inheritance;

import javax.persistence.Entity;

@Entity
public class CD extends Product {
	private String artist;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

}
