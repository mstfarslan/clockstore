package com.backendspringboot.clockstore.service;

import com.backendspringboot.clockstore.model.Clock;
import com.backendspringboot.clockstore.model.Order;
import com.backendspringboot.clockstore.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final ClockService clockService;
    private final OrderRepository orderRepository;

    public OrderService(ClockService clockService, OrderRepository orderRepository) {
        this.clockService = clockService;
        this.orderRepository = orderRepository;
    }
    public Order putAndOrder(List<Integer> clockIdList, String userName){
        List<Optional<Clock>>clockList = clockIdList.stream().
                map(clockService::findByClockId).collect(Collectors.toList());

        Double totalPrice = clockList.stream().
                map(optionalClock ->optionalClock.map(Clock::getPrice).orElse(0.0))
                .reduce(0.0,Double::sum);

        Order order = Order.builder()
                .clockList(clockIdList)
                .totalPrice(totalPrice)
                .userName(userName)
                .build();
        return orderRepository.save(order);
    }


    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
