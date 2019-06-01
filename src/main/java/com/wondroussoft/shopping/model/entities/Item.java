
package com.wondroussoft.shopping.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int price;
	private String size;
	private String color;
	private Long categoryId;
	private Boolean x;

	public boolean isX() {
		return x;
	}

	public void setX(boolean x) {
		this.x = x;
	}

	public Item() {
	}

	public Item(Long id, String name, Long categoryId, int price, String size,String color) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.size = size;
		this.color=color;
		this.categoryId = categoryId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
