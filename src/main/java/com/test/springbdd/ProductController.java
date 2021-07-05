package com.test.springbdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

	boolean logged = true;
	Logger log = LoggerFactory.getLogger(this.getClass());
	List<Product> l = new ArrayList<>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	ProductRepository repository;


	@Autowired
	public ProductController(ProductRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/logged")
	public ResponseEntity<Administrator> LoggedIn() {
		return ResponseEntity.ok(new Administrator("name","Email@Email.com","Username"));
	}
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> product(@PathVariable int id) {
		return ResponseEntity.ok(repository.findById(id));
	}

	@PutMapping(path = "/product/{id}/disable")
	public void DisableProduct(@PathVariable int id) {
		repository.findById(id).setEnable(false);
	}


	@PutMapping(path = "/product/{id}/enable")
	public void EnableProduct(@PathVariable int id) {
		repository.findById(id).setEnable(true);
	}

	@PutMapping(path = "/product/{id}/remove")
	public void RemoveProduct(@PathVariable int id) {
		repository.deleteById(id);
	}

	@GetMapping("/products/product/{id}/status")
	public String productStatus(@PathVariable int id) {
		Product product = repository.findById(id);
		if(product.getId()==id){
			if(product.getEnable()){
				return "Product enable";
			}
			else {
				return "Product Disable";
			}
		}
		return "Product removed";
	}

	@GetMapping("/product/addProduct")
	public void AddProduct( String description,
							 String status, Integer Unit,String data, Float price) {

		Product p = new Product(description,Unit,
				status, data, price,4);
		repository.save(p);
	}

	@GetMapping("/product/{id}/added")
	public String productAdded(@PathVariable int id) {
		return "Product added";
	}


	@GetMapping("/search/{keyword}")
	public ResponseEntity<Product> productStatusKeyword(@PathVariable String keyword) {
		return ResponseEntity.ok(repository.findByName(keyword));
	}

}
