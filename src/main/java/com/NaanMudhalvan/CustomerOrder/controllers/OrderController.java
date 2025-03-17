package com.NaanMudhalvan.CustomerOrder.controllers;

import com.NaanMudhalvan.CustomerOrder.DTO.OrderDTO;
import com.NaanMudhalvan.CustomerOrder.models.Customer;
import com.NaanMudhalvan.CustomerOrder.models.Order;
import com.NaanMudhalvan.CustomerOrder.services.CustomerService;
import com.NaanMudhalvan.CustomerOrder.services.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Tag(name = "Customer API", description = "Operations related to customers")
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return convertToDTO(order);
    }

    @PostMapping
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) {
        Customer customer = customerService.getCustomerById(orderDTO.getCustomerId());
        Order order = convertToEntity(orderDTO, customer);
        order.setId(null); // Ensure the ID is not set
        Order savedOrder = orderService.addOrder(order);
        return convertToDTO(savedOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    private OrderDTO convertToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setProductName(order.getProductName());
        dto.setQuantity(order.getQuantity());
        dto.setPrice(order.getPrice());
        dto.setCustomerId(order.getCustomer().getId());
        return dto;
    }

    private Order convertToEntity(OrderDTO dto, Customer customer) {
        Order order = new Order();
        order.setProductName(dto.getProductName());
        order.setQuantity(dto.getQuantity());
        order.setPrice(dto.getPrice());
        order.setCustomer(customer);
        return order;
    }
}