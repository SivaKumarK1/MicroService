package com.shoppingMall.customer.serviceImpl;

import com.shoppingMall.customer.controller.CustomerDetailsAPI;
import com.shoppingMall.customer.entity.OrderDetails;
import com.shoppingMall.customer.repository.CustomerDetailsRepository;
import com.shoppingMall.customer.repository.OrderDetailsRepository;
import com.shoppingMall.customer.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;
    private final CustomerDetailsRepository customerDetailsRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(CustomerDetailsAPI.class);


    @Override
    public OrderDetails saveOrders(OrderDetails orderDetails, Long custId) {
        orderDetails.setCustomerDetails(customerDetailsRepository.getById(custId));
        orderDetailsRepository.save(orderDetails);
        LOGGER.info("Data Posted to Database with id: " + orderDetails.getOrderId());
        return orderDetails;
    }

    @Override
    public List<OrderDetails> fetchCustomerOrders(Long custId) {

        return orderDetailsRepository.findByCustomerDetails(customerDetailsRepository.findById(custId));

    }

    @Override
    public OrderDetails updateCustomerOrders(OrderDetails orderDetails, Long custId, Long oId) {
        Optional<OrderDetails> orderDetails2 = orderDetailsRepository.findById(oId);
        if (!orderDetails2.isPresent()) {
            LOGGER.info("Does Not exists ");
        }

        LOGGER.info("Updated the db with new values ID: " + orderDetails.getOrderId());
        return orderDetailsRepository.save(orderDetails);

    }


    @Override
    public List<OrderDetails> fetchAllCustomerOrders() {
        LOGGER.info("Fetched All order Details ");

        return orderDetailsRepository.findAll();

    }
}
