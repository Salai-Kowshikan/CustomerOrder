package com.NaanMudhalvan.CustomerOrder.services;


import com.NaanMudhalvan.CustomerOrder.exceptions.ResourceNotFoundException;
import com.NaanMudhalvan.CustomerOrder.models.Order;
import com.NaanMudhalvan.CustomerOrder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrderById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
    }

    public Order addOrder(Order order) {
        return repository.save(order);
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
