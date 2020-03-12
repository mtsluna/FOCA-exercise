package ml.corp.main.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "api_stats")
@JsonInclude(Include.NON_NULL)
public class Stats {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "stats_id", updatable = false, nullable = false)
	private UUID id;

	@Column(name = "stats_hero_id")
	@JsonProperty(value = "hero-id")
	@JsonInclude(Include.NON_DEFAULT)
	private int heroId;
	
	@Column(name = "stats_date")
	private Date date = new Date();
	
	@Transient
	@JsonInclude(Include.NON_DEFAULT)
	private double average;
	
	@Transient
	private int quantity;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getHeroId() {
		return heroId;
	}

	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
