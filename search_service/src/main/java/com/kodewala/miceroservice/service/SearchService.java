package com.kodewala.miceroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.miceroservice.entity.Product;
import com.kodewala.miceroservice.repository.ProductReposatory;

@Service
public class SearchService {
	@Autowired
	private ProductReposatory repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public List<Product> searchByCategory(String category) {
		return repository.findByCategory(category);
	}

	public List<Product> searchByName(String Name) {
		return repository.findByNameContaining(Name);
	}
}
