package com.kodewala.order_miceroservice.feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kodewala.order_miceroservice.config.TracingFeignConfig;
import com.kodewala.order_miceroservice.dto.PaymentDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "payment-microservice", configuration = TracingFeignConfig.class)
public interface PaymentFeignClient {

	@CircuitBreaker(name = "paymentServiceCB", fallbackMethod = "fallbackPayment")
	@Retry(name = "paymentServiceRetry")
	@PostMapping("/makePayment")
	PaymentDTO makePayment(@RequestBody PaymentDTO payment);

	// Fallback method
	default PaymentDTO fallbackPayment(PaymentDTO payment, Throwable ex) {
		throw new RuntimeException("Payment service is currently unavailable. Please try later.");
	}
}
