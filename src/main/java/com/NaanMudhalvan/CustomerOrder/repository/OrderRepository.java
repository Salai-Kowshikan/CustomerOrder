package com.NaanMudhalvan.CustomerOrder.repository;
import com.NaanMudhalvan.CustomerOrder.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }