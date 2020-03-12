package ml.corp.main.entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Biography {

	@JsonProperty(value = "full-name")
	private String fullName;
	@JsonProperty(value = "alter-egos")
	private String alterEgos;
	private ArrayList<String> aliases = new ArrayList<String>();
	@JsonProperty(value = "place-of-birth")
	private String placeOfBirth;
	@JsonProperty(value = "first-appearance")
	private String firstAppearance;
	private String publisher;
	private String alignment;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAlterEgos() {
		return alterEgos;
	}

	public void setAlterEgos(String alterEgos) {
		this.alterEgos = alterEgos;
	}

	public ArrayList<String> getAliases() {
		return aliases;
	}

	public void setAliases(ArrayList<String> aliases) {
		this.aliases = aliases;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getFirstAppearance() {
		return firstAppearance;
	}

	public void setFirstAppearance(String firstAppearance) {
		this.firstAppearance = firstAppearance;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

}
