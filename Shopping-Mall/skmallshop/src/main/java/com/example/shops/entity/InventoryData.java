package com.example.shops.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InventoryData {
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "oracle_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private int inventoryId;
    private String inventoryName;
    private double inventoryWorth;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST, optional = true)
    private ShopData shopData;
}
