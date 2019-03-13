package com.cts.grizzlystore.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	private String id;
	private String name;
	private String category;
	private String description;
	private float price;
	private String brand;
	private float offer;
	private float rating;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
	@Column
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	@Column
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	@Column
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Column
	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}

	@Column
	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Column
	public float getOffer() {
		return offer;
	}


	public void setOffer(float offer) {
		this.offer = offer;
	}

	@Column
	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public Product(String id, String name, String category, String description, float price, String brand, float offer,
			float rating) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.brand = brand;
		this.offer = offer;
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", price=" + price + ", brand=" + brand + ", offer=" + offer + ", rating=" + rating + "]";
	}
	
	
	
}
