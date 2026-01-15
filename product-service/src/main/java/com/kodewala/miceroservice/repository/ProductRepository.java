package com.kodewala.miceroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.miceroservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
