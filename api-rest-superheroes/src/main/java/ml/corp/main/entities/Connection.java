package ml.corp.main.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Connection {

	@JsonProperty(value = "group-affiliation")
	private String groupAffiliation;
	private String relatives;

	public String getGroupAffiliation() {
		return groupAffiliation;
	}

	public void setGroupAffiliation(String groupAffiliation) {
		this.groupAffiliation = groupAffiliation;
	}

	public String getRelatives() {
		return relatives;
	}

	public void setRelatives(String relatives) {
		this.relatives = relatives;
	}

}
