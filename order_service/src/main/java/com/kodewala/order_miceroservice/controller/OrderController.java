package com.kodewala.order_miceroservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.order_miceroservice.dto.PaymentDTO;
import com.kodewala.order_miceroservice.feign_client.PaymentFeignClient;
import com.kodewala.order_miceroservice.order_entity.Order;
import com.kodewala.order_miceroservice.repo.OrderRepository;

@RestController
public class OrderController {

    private static final Logger log =
            LoggerFactory.getLogger(OrderController.class); 

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentFeignClient paymentFeign;

    @PostMapping("/placeOrder")
    public String createOrder(@RequestBody Order order) {

        log.info("Place order API called");   

        Order savedOrder = orderRepository.save(order);

        log.info("Order saved with id: {}", savedOrder.getId()); 

        PaymentDTO payment = new PaymentDTO();
        payment.setOrderId(savedOrder.getId());
        payment.setAmount(savedOrder.getPrice());

        log.info("Calling payment service"); 

        PaymentDTO response = paymentFeign.makePayment(payment);

        log.info("Payment response received: {}", response.getStatus()); 

        return "Payment Status: " + response.getStatus();
    }

    @GetMapping("/getOrder")
    public List<Order> getAllOrders() {

        log.info("Fetching all orders"); 

        return orderRepository.findAll();
    }

    @GetMapping("/")
    public String home() {

        log.info("Home API called"); 

        return "Order Service is running";
    }
}
