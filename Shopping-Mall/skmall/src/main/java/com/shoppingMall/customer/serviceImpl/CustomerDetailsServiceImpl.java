package com.shoppingMall.customer.serviceImpl;

import com.shoppingMall.customer.controller.CustomerDetailsAPI;
import com.shoppingMall.customer.entity.CustomerDetails;
import com.shoppingMall.customer.repository.CustomerDetailsRepository;
import com.shoppingMall.customer.service.CustomerDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(CustomerDetailsAPI.class);


    @Override
    public CustomerDetails saveCustomers(CustomerDetails customerDetails) {
        customerDetailsRepository.save(customerDetails);
        LOGGER.info("Data Posted to Database with ID: " + customerDetails.getCustId());
        return customerDetails;
    }

    @Override
    public List<CustomerDetails> fetchAllCustomers() {
        LOGGER.info("All Data Fetched From Database");
        return customerDetailsRepository.findAll();
    }

    @Override
    public void deleteCustomer(Long custId) {
        if (customerDetailsRepository.findById(custId).isEmpty()) {
            LOGGER.info("Does Not exists");
//            System.out.println("Does Not Exists");
        } else {
            customerDetailsRepository.deleteById(custId);
            LOGGER.info("Data Deleted from Database with ID: " + custId);

        }

    }

    @Override
    public CustomerDetails fetchAllCustomerById(Long custId) {
        Optional<CustomerDetails> customerDetails = customerDetailsRepository.findById(custId);

        if (!customerDetails.isPresent()) {
            LOGGER.info("Does Not exists");
        }

        return customerDetails.get();

    }

    @Override
    public CustomerDetails updateCustomers(CustomerDetails customerDetails, Long custId) {
        Optional<CustomerDetails> customerDetails2 = customerDetailsRepository.findById(custId);

        if (!customerDetails2.isPresent()) {
             LOGGER.info("Does Not exists Added a new record with ID:" + customerDetails.getCustId());
        }
        LOGGER.info("Updated the db with new values ID: " + customerDetails.getCustId());
        return customerDetailsRepository.save(customerDetails);
    }
}
