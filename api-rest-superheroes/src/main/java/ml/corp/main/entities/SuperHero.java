package ml.corp.main.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SuperHero {

	private int id;
	private String name;
	private PowerStats powerstats;
	private Biography biography;
	private Appearance appearance;
	private Work work;
	private Connection connections;
	private Image image;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PowerStats getPowerstats() {
		return powerstats;
	}

	public void setPowerstats(PowerStats powerstats) {
		this.powerstats = powerstats;
	}

	public Biography getBiography() {
		return biography;
	}

	public void setBiography(Biography biography) {
		this.biography = biography;
	}

	public Appearance getAppearance() {
		return appearance;
	}

	public void setAppearance(Appearance appearance) {
		this.appearance = appearance;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public Connection getConnections() {
		return connections;
	}

	public void setConnections(Connection connections) {
		this.connections = connections;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

}
