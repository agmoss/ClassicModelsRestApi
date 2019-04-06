package com.agmoss.ClassicModelsRestApi.controller;

import com.agmoss.ClassicModelsRestApi.exception.ResourceNotFoundException;
import com.agmoss.ClassicModelsRestApi.model.OrdersEntity;
import com.agmoss.ClassicModelsRestApi.repository.OrderDetailsRepository;
import com.agmoss.ClassicModelsRestApi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

    @GetMapping("/orders")
    public List<OrdersEntity> getAllOrders(){
        return orderRepository.findAll();
    }

    // Get a Single Order (important endpoint
    @GetMapping("/orders/{id}")
    public OrdersEntity getOrderById(@PathVariable(value = "id") int orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));
    }

    // Create a new order
    @RequestMapping(value = "/orders", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrdersEntity createOrder(@Valid @RequestBody OrdersEntity order) {
        return orderRepository.save(order);
    }

    // Update an order
    @PutMapping("/orders/{id}")
    public OrdersEntity updateOrder(@PathVariable(value = "id") Integer orderId,
                           @Valid @RequestBody OrdersEntity orderToUpdate) {

        OrdersEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));

        order.setComments(orderToUpdate.getComments());
        order.setOrderDate(orderToUpdate.getOrderDate());
        order.setRequiredDate(orderToUpdate.getRequiredDate());
        order.setShippedDate(orderToUpdate.getShippedDate());
        order.setStatus(orderToUpdate.getStatus());

        order.setDetails(orderToUpdate.getDetails());

        //Same order number (id)
        order.setOrderNumber(orderId);

        OrdersEntity updatedOrder = orderRepository.save(order);

        return updatedOrder;
    }

    // Delete a order
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable(value = "id") Integer orderId) {
        OrdersEntity order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "id", orderId));

        // Delete order details
        orderDetailsRepository.deleteAll(order.getDetails());

        // Then delete the order
        orderRepository.delete(order);

        return ResponseEntity.ok().build();
    }

}
