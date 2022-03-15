package com.shoppingMall.customer.service;

import com.shoppingMall.customer.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

    OrderDetails saveOrders(OrderDetails orderDetails, Long custId);

    List<OrderDetails> fetchCustomerOrders(Long custId);

    OrderDetails updateCustomerOrders(OrderDetails orderDetails,Long custId, Long oId);

    List<OrderDetails> fetchAllCustomerOrders();
}
