package com.backendspringboot.clockstore.controller;


import com.backendspringboot.clockstore.dto.ClockOrderRequest;
import com.backendspringboot.clockstore.model.Clock;
import com.backendspringboot.clockstore.model.Order;
import com.backendspringboot.clockstore.service.ClockService;
import com.backendspringboot.clockstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/h1/store")
public class ClockStoreController {

    private final OrderService orderService;
    private final ClockService clockService;

    public ClockStoreController(OrderService orderService, ClockService clockService) {
        this.orderService = orderService;
        this.clockService = clockService;
    }
    @GetMapping("/clocks")
    public ResponseEntity<List<Clock>> getAllClocks(){
        List<Clock> clockList = clockService.getAllClocks();
        return ResponseEntity.ok(clockList);
    }


    @GetMapping("/orders")
    public ResponseEntity<List<Order>>gelAllOrders(){
        List<Order>orderList = orderService.getAllOrders();
        return ResponseEntity.ok(orderList);
    }

    @PostMapping
    public ResponseEntity<Order>putAnOrder(@RequestBody ClockOrderRequest clockOrderRequest){
        Order order = orderService.putAndOrder(clockOrderRequest.getClockIdList(), clockOrderRequest.getUserName());

        return ResponseEntity.ok(order);
    }

}
