package com.NaanMudhalvan.CustomerOrder.controllers;

import com.NaanMudhalvan.CustomerOrder.models.Customer;
import com.NaanMudhalvan.CustomerOrder.services.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name="Customer API", description= " operations related to customers")
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer)
    {
        return service.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers()
    {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id)
    {
        return service.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id)
    {
        service.deleteCustomer(id);
    }

}