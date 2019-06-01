package com.wondroussoft.shopping.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Wear {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long seasonId;
	private Boolean x;

	@OneToMany(mappedBy = "wearId")
	private List<Category> categories;


	public Wear() {

	}

	public Wear(Long id, String name, Long seasonId) {
		this.id = id;
		this.name = name;
		this.seasonId = seasonId;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(Long seasonId) {
		this.seasonId = seasonId;
	}

	public Boolean getX() {
		return x;
	}

	public void setX(Boolean x) {
		this.x = x;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
