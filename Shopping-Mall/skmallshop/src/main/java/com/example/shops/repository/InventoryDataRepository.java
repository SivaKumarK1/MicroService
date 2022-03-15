package com.example.shops.repository;

import com.example.shops.entity.InventoryData;
import com.example.shops.entity.ShopData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryDataRepository extends JpaRepository<InventoryData, Integer> {
    List<InventoryData> findByShopData(Optional<ShopData> shopId);
}
