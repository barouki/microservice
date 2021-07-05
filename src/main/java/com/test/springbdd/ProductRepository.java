package com.test.springbdd;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findById(int id);
	Product deleteById(int id);
	Product findByName(String name);
}
