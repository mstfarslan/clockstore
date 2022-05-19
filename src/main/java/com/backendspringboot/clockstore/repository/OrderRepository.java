package com.backendspringboot.clockstore.repository;

import com.backendspringboot.clockstore.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
