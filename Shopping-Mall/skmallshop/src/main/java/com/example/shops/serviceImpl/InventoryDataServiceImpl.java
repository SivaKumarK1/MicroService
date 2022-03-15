package com.example.shops.serviceImpl;

import com.example.shops.controller.ShopDataAPI;
import com.example.shops.entity.InventoryData;
import com.example.shops.repository.InventoryDataRepository;
import com.example.shops.repository.ShopDataRepository;
import com.example.shops.service.InventoryDataService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryDataServiceImpl implements InventoryDataService {
    private final InventoryDataRepository inventoryDataRepository;
    private final ShopDataRepository shopDataRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(ShopDataAPI.class);

    @Override
    public InventoryData saveInventory(InventoryData inventoryData, int shopId) {
        inventoryData.setShopData(shopDataRepository.getById(shopId));
        inventoryDataRepository.save(inventoryData);
        LOGGER.info("Data Posted to Database with id: " + inventoryData.getInventoryId());
        return inventoryData;
    }

    @Override
    public List<InventoryData> fetchInventoryData(int shopId) {
        return inventoryDataRepository.findByShopData(shopDataRepository.findById(shopId));
    }

    @Override
    public InventoryData updateInventoryData(InventoryData inventoryData, int shopId, int inventoryId) {
        Optional<InventoryData> orderDetails2 = inventoryDataRepository.findById(inventoryId);
        if (!orderDetails2.isPresent()) {
            LOGGER.info("Inventory Does Not exists ");
        }
        LOGGER.info("Inventory Updated the db with new values ID: " + inventoryData.getInventoryId());
        return inventoryDataRepository.save(inventoryData);
    }

    @Override
    public List<InventoryData> fetchAllInventoryData() {
        LOGGER.info("Fetched All Inventory Data ");
        return inventoryDataRepository.findAll();
    }
}
