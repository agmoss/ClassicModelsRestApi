package com.agmoss.ClassicModelsRestApi.controller;

import com.agmoss.ClassicModelsRestApi.model.OrderdetailsEntity;
import com.agmoss.ClassicModelsRestApi.repository.OrderDetailsRepository;
import com.agmoss.ClassicModelsRestApi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/orders/{ordernumber}/orderdetails")
    public List<OrderdetailsEntity> getAllOrderDetailsByOrderId(@PathVariable (value = "ordernumber") Integer orderId){

        return orderDetailsRepository.findByorderNumber(orderId);

    }

}
