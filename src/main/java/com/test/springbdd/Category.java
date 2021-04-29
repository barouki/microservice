package com.test.springbdd;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;


@Entity
public class Category {
    
	@Id
    private int id;
    
	String name;
		
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
	public Category() {
		
	}
	
	public Category(String name, int id) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return String.format("Category[id: %d, name: %s, products: %s]", id, name, products.toString());
	}
	
	public List<Product> getProducts(){
		return products;
	}	
}
