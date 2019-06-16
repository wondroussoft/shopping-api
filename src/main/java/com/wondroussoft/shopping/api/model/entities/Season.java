package com.wondroussoft.shopping.api.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Season {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Boolean x;

//	@OneToMany(mappedBy = "seasonId")
//	private List<Wear> wears;

	public Season() {
	}

	public Season(Long id, String name) {
		this.id = id;
		this.name = name;
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

	public Boolean getX() {
		return x;
	}

	public void setX(Boolean x) {
		this.x = x;
	}

//	public List<Wear> getWears() {
//		return wears;
//	}
//
//	public void setWears(List<Wear> wears) {
//		this.wears = wears;
//	}

}
