package com.kodewala.order_miceroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodewala.order_miceroservice.order_entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
