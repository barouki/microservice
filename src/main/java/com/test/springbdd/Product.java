package com.test.springbdd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	private int id;
	
	String name;

	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	public Product() {
	}
	
	public Product(String name, Category category, int id) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
	}
	
	public String getName() {
		return name;
	}

	public int getId(){
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return String.format("Product[id:%d, name:%s]", id, name);
	}

}
