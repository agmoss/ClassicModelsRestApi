package com.agmoss.ClassicModelsRestApi.controller;

import com.agmoss.ClassicModelsRestApi.model.OrderdetailsEntity;
import com.agmoss.ClassicModelsRestApi.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderDetailsController {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/orders/{ordernumber}/orderdetails")
    public List<OrderdetailsEntity> getAllOrderDetailsByOrderId(@PathVariable(value = "ordernumber") Integer orderId) {

        return orderDetailsRepository.findByorderNumber(orderId);

    }

    // Get a Single Order detail
    @GetMapping("/orderdetails/{id}/{code}")
    public OrderdetailsEntity getByIds(@PathVariable(value = "id") int orderId, @PathVariable(value = "code") String prodCode) {
        return orderDetailsRepository.getByNames(orderId, prodCode);

    }

    // Create a new order detail
    @RequestMapping(value = "/orderdetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderdetailsEntity createOrderDetails(@Valid @RequestBody OrderdetailsEntity orderDetail) {
        return orderDetailsRepository.save(orderDetail);
    }

    // Delete an order detail
    @DeleteMapping("/orderdetail/{id}/{code}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable(value = "id") int orderId, @PathVariable(value = "code") String prodCode) {

        OrderdetailsEntity detailToDelete = orderDetailsRepository.getByNames(orderId, prodCode);

        // Delete order details
        orderDetailsRepository.delete(detailToDelete);

        return ResponseEntity.ok().build();
    }

    // Update an order detail
    @PutMapping("/orderdetail/{id}/{code}")
    public OrderdetailsEntity updateOrder(@PathVariable(value = "id") int orderId, @PathVariable(value = "code") String prodCode,
                                          @Valid @RequestBody OrderdetailsEntity orderDetailToUpdate) {

        OrderdetailsEntity orderDetail = orderDetailsRepository.getByNames(orderId, prodCode);

        // Update
        orderDetail.setOrderLineNumber(orderDetailToUpdate.getOrderLineNumber());
        orderDetail.setPriceEach(orderDetailToUpdate.getPriceEach());
        orderDetail.setProductCode(orderDetailToUpdate.getProductCode());
        orderDetail.setQuantityOrdered(orderDetailToUpdate.getQuantityOrdered());

        OrderdetailsEntity updatedOrderDetail = orderDetailsRepository.save(orderDetail);

        return updatedOrderDetail;

    }

}
