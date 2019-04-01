package com.agmoss.ClassicModelsRestApi.controller;

import com.agmoss.ClassicModelsRestApi.exception.ResourceNotFoundException;
import com.agmoss.ClassicModelsRestApi.model.OrdersEntity;
import com.agmoss.ClassicModelsRestApi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/orders")
    public List<OrdersEntity> getAllOrders(){

        return orderRepository.findAll();

    }

    // Get a Single Note
    @GetMapping("/orders/{id}")
    public OrdersEntity getNoteById(@PathVariable(value = "id") int orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", orderId));
    }


}
