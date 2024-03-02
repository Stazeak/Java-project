package com.example.springSecurityApplication.services;


import com.example.springSecurityApplication.models.Order;
import com.example.springSecurityApplication.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    // возвращение заказа по id
    public Order getOrderId (int id){
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }
    // обновление статуса заказа
    @Transactional
    public void updateOrder(Order order){
        orderRepository.save(order);
    }
}
