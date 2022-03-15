package com.shoppingMall.customer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderDetails {
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "oracle_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long orderId;
    private Double orderAmount;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, optional = true)
    private CustomerDetails customerDetails;

}
