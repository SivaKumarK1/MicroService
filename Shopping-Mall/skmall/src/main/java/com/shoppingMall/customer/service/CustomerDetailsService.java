package com.shoppingMall.customer.service;

import com.shoppingMall.customer.entity.CustomerDetails;


import java.util.List;


public interface CustomerDetailsService {


    CustomerDetails saveCustomers(CustomerDetails customerDetails);

    List<CustomerDetails> fetchAllCustomers();

    void deleteCustomer(Long custId);

    CustomerDetails fetchAllCustomerById(Long custId);

    CustomerDetails updateCustomers(CustomerDetails customerDetails, Long custId);
}
