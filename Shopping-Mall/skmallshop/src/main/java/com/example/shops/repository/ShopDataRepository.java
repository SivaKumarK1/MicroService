package com.example.shops.repository;

import com.example.shops.entity.ShopData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDataRepository extends JpaRepository<ShopData, Integer> {
}
