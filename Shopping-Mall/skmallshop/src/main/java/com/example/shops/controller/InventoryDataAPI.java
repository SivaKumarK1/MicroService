package com.example.shops.controller;

import com.example.shops.entity.InventoryData;
import com.example.shops.service.InventoryDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class InventoryDataAPI {

    private final InventoryDataService inventoryDataService;

    @PostMapping("/{shopId}/inventory")
    public InventoryData saveInventory(@RequestBody InventoryData inventoryData, @PathVariable("shopId") int shopId) {
        return inventoryDataService.saveInventory(inventoryData, shopId);

    }

    @GetMapping("/{shopId}/inventory")
    public List<InventoryData> getInventoryData(@PathVariable("shopId") int shopId) {
        System.out.println("Entered ------>" + shopId);
        return inventoryDataService.fetchInventoryData(shopId);

    }
    @GetMapping("/inventory")
    public List<InventoryData> getAllInventoryData() {
        return inventoryDataService.fetchAllInventoryData();

    }

    @PutMapping("/{shopId}/inventory/{inventoryId}")
    public InventoryData editInventoryData(@RequestBody InventoryData inventoryData, @PathVariable("shopId") int shopId, @PathVariable("inventoryId") int inventoryId) {
        return inventoryDataService.updateInventoryData(inventoryData, shopId, inventoryId);

    }
}
