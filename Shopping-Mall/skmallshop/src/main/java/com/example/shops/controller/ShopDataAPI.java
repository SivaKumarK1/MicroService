package com.example.shops.controller;

import com.example.shops.entity.ShopData;
import com.example.shops.service.ShopsDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ShopDataAPI {
    @Autowired
    private ShopsDataService shopsDataService;

    @PostMapping("/shops")
    private ShopData saveShops(@RequestBody ShopData shopData) {
        shopsDataService.saveShops(shopData);
        return shopData;
    }

    @GetMapping("/shops")
    private List<ShopData> getAllShops() {
        return shopsDataService.fetchAllShops();

    }

    @GetMapping("/shops/{shopId}")
    private ShopData getShopsById(@PathVariable("shopId") int shopId){
        return shopsDataService.fetchAllshopById(shopId);
    }

    @DeleteMapping("/shops/{shopId}")
    private String deleteShopDetails(@PathVariable("shopId") int shopId) {
        shopsDataService.deleteShop(shopId);
        return "Delete";
    }

    @PutMapping("/shops/{shopId}")
    private ShopData updateShopById(@RequestBody ShopData shopData, @PathVariable("shopId") int shopId) {
        return shopsDataService.updateShops(shopData, shopId);
    }

}
