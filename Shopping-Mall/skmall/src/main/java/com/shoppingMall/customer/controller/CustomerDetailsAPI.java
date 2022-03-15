package com.shoppingMall.customer.controller;

import com.shoppingMall.customer.entity.CustomerDetails;
import com.shoppingMall.customer.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerDetailsAPI {
    @Autowired
    private CustomerDetailsService customerDetailsService;

    @PostMapping("/customers")
    private CustomerDetails saveCustomers(@RequestBody CustomerDetails customerDetails) {
        customerDetailsService.saveCustomers(customerDetails);
        return customerDetails;
    }

    @GetMapping("/customers")
    private List<CustomerDetails> getAllCustomers() {
        return customerDetailsService.fetchAllCustomers();

    }

    @GetMapping("/customers/{cust-id}")
    private CustomerDetails getCustomerById(@PathVariable("cust-id") Long custId) {
        return customerDetailsService.fetchAllCustomerById(custId);


    }


    @DeleteMapping("/customers/{cust-id}")
    private String deleteCustomerDetails(@PathVariable("cust-id") Long custId) {
        customerDetailsService.deleteCustomer(custId);
        return "Delete";
    }

    @PutMapping("/customers/{cust-id}")
    private CustomerDetails updateCustomerById(@RequestBody CustomerDetails customerDetails, @PathVariable("cust-id") Long custId) {
        return customerDetailsService.updateCustomers(customerDetails, custId);

    }


}
