package com.test.springbdd;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@Column(name="id")
	int id;
	@Column(name="name")
	String name;

	String description;
	int Units;
	String status;
	@Column(name="data")
	String data;
	float price;
	boolean enable;

	
	public Product() {
	}
	
	public Product(String name, int id) {
		super();
		this.id = id;
		this.name = name;

	}

	public Product( String description, int Units, String status, String data, float price, int id){
		super();

		this.description = description;
		this.Units = Units;
		this.status = status;
		this.data = data;
		this.price = price;
		this.id=id;
		this.enable=true;
	}



	public void setDescription(String description) {
		this.description = description;
	}

	public void setUnits(int units) {
		Units = units;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDescription(){
		return this.description;
	}
	public int getUnits(){
		return this.Units;
	}
	public String getStatus(){
		return this.status;
	}

	public String getData(){
		return this.data;
	}

	public float getPrice(){
		return this.price;
	}

	public int getId(){
		return this.id;
	}

	public boolean getEnable(){
		return this.enable;
	}
	public void setEnable(boolean bool){
		this.enable=bool;
	}

	
	public String toString() {
		return String.format("Product[id:%d, name:%s]", id, name);
	}

}
