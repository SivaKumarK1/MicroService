package com.example.shops.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShopData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int shopId;
    private String shopName;
    private String shopAddr;
    private String ownerName;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "shopData")
    private List<InventoryData> inventoryData;
}
