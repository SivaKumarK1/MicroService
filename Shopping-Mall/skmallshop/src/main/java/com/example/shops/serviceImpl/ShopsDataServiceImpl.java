package com.example.shops.serviceImpl;

import com.example.shops.controller.ShopDataAPI;
import com.example.shops.entity.ShopData;
import com.example.shops.repository.ShopDataRepository;
import com.example.shops.service.ShopsDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopsDataServiceImpl implements ShopsDataService {
    @Autowired
    private ShopDataRepository shopDataRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(ShopDataAPI.class);


    @Override
    public ShopData saveShops(ShopData shopData) {
        shopDataRepository.save(shopData);
        LOGGER.info("Data Posted to Database with ID: " + shopData.getShopId());
        return shopData;
    }

    @Override
    public List<ShopData> fetchAllShops() {
        LOGGER.info("All Data Fetched From Database");
        return shopDataRepository.findAll();
    }

    @Override
    public void deleteShop(int shopId) {
        if (shopDataRepository.findById(shopId).isEmpty()) {
            LOGGER.info("Shop does Not exists");
        } else {
            shopDataRepository.deleteById(shopId);
            LOGGER.info("Shop Data Deleted from Database with ID: " + shopId);
        }
    }

    @Override
    public ShopData fetchAllshopById(int shopId) {
        Optional<ShopData> customerDetails = shopDataRepository.findById(shopId);
        if (!customerDetails.isPresent()) {
            LOGGER.info("Shop does Not exists");
        }
        return customerDetails.get();
    }

    @Override
    public ShopData updateShops(ShopData shopData, int shopId) {
        Optional<ShopData> customerDetails2 = shopDataRepository.findById(shopId);

        if (!customerDetails2.isPresent()) {
            LOGGER.info("Does Not exists Added a new record with ID:" + shopData.getShopId());
        }
        LOGGER.info("Updated the db with new values ID: " + shopData.getShopId());
        return shopDataRepository.save(shopData);
    }
}
