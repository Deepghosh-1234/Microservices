package com.kodewala.order_miceroservice.feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kodewala.order_miceroservice.dto.ProductDTo;

@FeignClient(name = "product-service")
public interface ProductFeignClient {
	@GetMapping("/products/{id}")
	ProductDTo getProductById(@PathVariable("id") Long id);
}
