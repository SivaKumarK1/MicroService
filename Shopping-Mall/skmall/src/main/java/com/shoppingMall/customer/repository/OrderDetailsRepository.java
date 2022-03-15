package com.shoppingMall.customer.repository;

import com.shoppingMall.customer.entity.CustomerDetails;
import com.shoppingMall.customer.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
    List<OrderDetails> findByCustomerDetails(Optional<CustomerDetails> custId);

}
