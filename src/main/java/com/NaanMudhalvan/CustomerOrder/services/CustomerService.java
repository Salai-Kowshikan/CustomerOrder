package com.NaanMudhalvan.CustomerOrder.services;

import com.NaanMudhalvan.CustomerOrder.exceptions.ResourceNotFoundException;
import com.NaanMudhalvan.CustomerOrder.models.Customer;
import com.NaanMudhalvan.CustomerOrder.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public Customer addCustomer(Customer customer)
    {
        return repository.save(customer);
    }

    public List<Customer>getAllCustomers()
    {
        return repository.findAll();
    }

    public Customer getCustomerById(Long id)
    {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer Not found"));
    }

    public void deleteCustomer(Long id)
    {
        repository.deleteById(id);
    }


}