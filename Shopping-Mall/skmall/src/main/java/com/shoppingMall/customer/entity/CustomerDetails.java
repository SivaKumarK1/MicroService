package com.shoppingMall.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long custId;
    private String custName;
    private String custAddress;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "customerDetails")
    private List<OrderDetails> orderDetails;


}
