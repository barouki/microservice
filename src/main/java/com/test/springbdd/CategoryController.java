package com.test.springbdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryRepository repository;
	
	@GetMapping("/getCategory")
	public ResponseEntity<Category> getCategory(@RequestParam int id){
		
		Category category = repository.findById(id);
		
		repository.save(category);
		
		return ResponseEntity.ok(category);
	}
}
