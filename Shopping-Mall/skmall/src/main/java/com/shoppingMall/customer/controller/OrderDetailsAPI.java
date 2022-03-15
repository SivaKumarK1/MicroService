package com.shoppingMall.customer.controller;

import com.shoppingMall.customer.entity.CustomerDetails;
import com.shoppingMall.customer.entity.OrderDetails;
import com.shoppingMall.customer.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderDetailsAPI {
    private final OrderDetailsService orderDetailsService;

    @PostMapping("/{cust-id}/orders")
    public OrderDetails saveOrders(@RequestBody OrderDetails orderDetails, @PathVariable("cust-id") Long custId) {
        return orderDetailsService.saveOrders(orderDetails, custId);

    }

    @GetMapping("/{cust-id}/orders")
    public List<OrderDetails> getCustomerOrders(@PathVariable("cust-id") Long custId) {
        System.out.println("Entered ------>" + custId);
        return orderDetailsService.fetchCustomerOrders(custId);

    }
    @GetMapping("/orders")
    public List<OrderDetails> getAllCustomerOrders() {
        return orderDetailsService.fetchAllCustomerOrders();

    }

    @PutMapping("/{cust-id}/orders/{oId}")
    public OrderDetails editCustomerOrders(@RequestBody OrderDetails orderDetails, @PathVariable("cust-id") Long custId, @PathVariable("oId") Long oId) {
        return orderDetailsService.updateCustomerOrders(orderDetails, custId, oId);

    }



}
