package ml.corp.main.entities;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Appearance {

	private String gender;
	private String race;
	private ArrayList<String> height = new ArrayList<String>();
	private ArrayList<String> weight = new ArrayList<String>();
	@JsonProperty(value = "eye-color")
	private String eyeColor;
	@JsonProperty(value = "hair-color")
	private String hairColor;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public ArrayList<String> getHeight() {
		return height;
	}

	public void setHeight(ArrayList<String> height) {
		this.height = height;
	}

	public ArrayList<String> getWeight() {
		return weight;
	}

	public void setWeight(ArrayList<String> weight) {
		this.weight = weight;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

}
