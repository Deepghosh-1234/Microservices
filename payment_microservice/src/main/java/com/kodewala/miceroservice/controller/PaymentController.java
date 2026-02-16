package com.kodewala.miceroservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.miceroservice.entity.Payment;
import com.kodewala.miceroservice.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private static final Logger log =
            LoggerFactory.getLogger(PaymentController.class); 

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/makePayment")
    public Payment makePayment(@RequestBody Payment payment) {

        log.info("Payment API called");
        log.info("OrderId: {}, Amount: {}",
                payment.getOrderId(),
                payment.getAmount()); 

        Payment response = paymentService.processPayment(payment);

        log.info("Payment Status: {} for orderId: {}",
                response.getStatus(),
                response.getOrderId()); 

        return response;
    }

    @GetMapping("/")
    public String home() {

        log.info("Payment Service home API called"); 
        return "Payment Service is running";
    }
}
