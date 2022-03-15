package com.shoppingmall.parking.controller;

import com.shoppingmall.parking.entity.Vehicle;
import com.shoppingmall.parking.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class VehicleAPI {
    private final VehicleService vehicleService;

    @PostMapping("/vehicle")
    private Vehicle saveVehicleDetails(@RequestBody Vehicle vehicle) {
//        System.out.println("Vehicle Checking" + vehicle);
        return vehicleService.saveDetails(vehicle);
    }


    @GetMapping("/vehicle")
    private List<Vehicle> getAllVehicleDetails() {
        return vehicleService.fetchAllVechileDetails();
    }

    @GetMapping("/vehicle/{v-id}")
    private Vehicle getVehicleDetailsById(@PathVariable("v-id") Long vehicleId) {
        return vehicleService.fetchVechileDetailsById(vehicleId);

    }

    @DeleteMapping("/vehicle/{v-id}")
    private String deleteVehicleDetailsById(@PathVariable("v-id") Long vehicleId) {
        vehicleService.deleteParkingDetailsById(vehicleId);
        return "Delete";
    }


    @PutMapping("/vehicle/{v-id}")
    private Vehicle updateVehicleDetails(@RequestBody Vehicle vehicle, @PathVariable("v-id") Long vehicleId) {
        return vehicleService.updateParkingDetails(vehicle, vehicleId);
    }


}
