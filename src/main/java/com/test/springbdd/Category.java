package com.test.springbdd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
    
	@Id
    private int id;
    
	String name;

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
		return String.format("Category[id:%d, name:%s]", id, name);
	}
}
