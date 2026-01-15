package com.kodewala.miceroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.miceroservice.entity.Product;
import com.kodewala.miceroservice.service.SearchService;

@RestController
public class SearchController {
	@Autowired
	private SearchService searchService;
	@PostMapping("/addProduct")
	public  Product addProduct(@RequestBody Product product)
	{
		return searchService.saveProduct(product);
	}
	 @GetMapping("/getProducts")
	public List<Product> getAllProducts()
	{
		return searchService.getAllProducts();
	}
	@GetMapping("/category/{category}")
    public List<Product> searchByCategory(@PathVariable String category) {
        return searchService.searchByCategory(category);
    }

    @GetMapping("/name/{name}")
    public List<Product> searchByName(@PathVariable String name) {
        return searchService.searchByName(name);
    }

    @GetMapping("/")
    public String home() {
        return "Search Service is running";
    }
	
	
}
