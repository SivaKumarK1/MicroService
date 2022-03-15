package com.example.shops.service;

import com.example.shops.entity.InventoryData;

import java.util.List;

public interface InventoryDataService {
    InventoryData saveInventory(InventoryData inventoryData, int shopId);

    List<InventoryData> fetchInventoryData(int shopId);

    InventoryData updateInventoryData(InventoryData inventoryData,int shopId, int inventoryId);

    List<InventoryData> fetchAllInventoryData();
}
