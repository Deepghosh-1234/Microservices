package com.kodewala.miceroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.miceroservice.entity.Payment;
import com.kodewala.miceroservice.service.PaymentService;

@RestController
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@PostMapping("/makePayment")
	public Payment makePayment(@RequestBody Payment payment) {
		return paymentService.processPayment(payment);
	}

	@GetMapping("/")
	public String home() {
		return "Payment Service is running";
	}
}
