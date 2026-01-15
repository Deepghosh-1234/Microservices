package com.kodewala.miceroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.miceroservice.entity.Payment;
import com.kodewala.miceroservice.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	public Payment processPayment(Payment payment) {

		if (payment.getAmount() > 0) {
			payment.setStatus("SUCCESS");
		} else {
			payment.setStatus("FAILED");
		}

		return paymentRepository.save(payment);
	}
}