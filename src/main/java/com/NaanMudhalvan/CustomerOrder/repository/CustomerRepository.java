package com.NaanMudhalvan.CustomerOrder.repository;

import com.NaanMudhalvan.CustomerOrder.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }