package com.agmoss.ClassicModelsRestApi.controller;

import com.agmoss.ClassicModelsRestApi.exception.ResourceNotFoundException;
import com.agmoss.ClassicModelsRestApi.model.OrderdetailsEntity;
import com.agmoss.ClassicModelsRestApi.model.OrdersEntity;
import com.agmoss.ClassicModelsRestApi.repository.OrderDetailsRepository;
import com.agmoss.ClassicModelsRestApi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderRepository orderRepository;

    //@GetMapping("/orders/{orderId}/orderdetails")
    @RequestMapping(method = RequestMethod.GET, value = "/orders/{ordernumber}/orderdetails")
    public List<OrderdetailsEntity> getAllOrderDetailsByOrderId(@PathVariable (value = "ordernumber") Integer orderId){

        return orderDetailsRepository.findByorderNumber(orderId);

    }

}
