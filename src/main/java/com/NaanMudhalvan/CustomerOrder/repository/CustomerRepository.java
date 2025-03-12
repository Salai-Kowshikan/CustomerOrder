package com.NaanMudhalvan.CustomerOrder.repository;

import com.ecom.customerorder.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }