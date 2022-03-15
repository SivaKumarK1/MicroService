package com.example.shops.service;

import com.example.shops.entity.ShopData;

import java.util.List;


public interface ShopsDataService {

    ShopData saveShops(ShopData shopData);

    List<ShopData> fetchAllShops();

    void deleteShop(int shopId);

    ShopData fetchAllshopById(int shopId);

    ShopData updateShops(ShopData shopData, int shopId);
}
