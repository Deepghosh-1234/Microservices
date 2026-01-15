package com.kodewala.order_miceroservice.feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kodewala.order_miceroservice.config.TracingFeignConfig;
import com.kodewala.order_miceroservice.dto.PaymentDTO;

@FeignClient(name = "payment-microservice", configuration = TracingFeignConfig.class)
public interface PaymentFeignClient {

	@PostMapping("/makePayment")
	PaymentDTO makePayment(@RequestBody PaymentDTO payment);
}
