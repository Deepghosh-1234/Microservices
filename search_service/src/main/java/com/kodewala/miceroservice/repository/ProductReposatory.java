package com.kodewala.miceroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.miceroservice.entity.Product;

public interface ProductReposatory extends JpaRepository<Product, Long> {
	List<Product> findByCategory(String category);

	List<Product> findByNameContaining(String name);
}
