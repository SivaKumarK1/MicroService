package com.shoppingmall.parking.controller;


import com.shoppingmall.parking.entity.Parking;
import com.shoppingmall.parking.service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ParkingAPI {
    private final ParkingService parkingService;

    @PostMapping("/{v-id}/parking")
    private Parking saveParkingDetails(@RequestBody Parking parking, @PathVariable("v-id") Long vehicleId) {
//        System.out.println(parking+" dgkjdfhkush" + vehicleId);
        return parkingService.saveDetails(parking, vehicleId);
    }


    @GetMapping("/{v-id}/parking")
    private List<Parking> getAllParkingDetails(@PathVariable() Long vehicleId) {
        System.out.println("Entered ------>" + vehicleId);
        return parkingService.fetchAllParkingDetails(vehicleId);
    }

    //
    @GetMapping("/parking")
    public List<Parking> getAllVehicleParking() {
        return parkingService.fetchAllVehicleParking();

    }

    @GetMapping("/parking/{p-id}")
    private Parking getDetailsById(@PathVariable("p-id") Long parkId) {
        return parkingService.fetchParkingDetailsById(parkId);

    }

    @DeleteMapping("/parking/{p-id}")
    private String deleteDetailsById(@PathVariable("p-id") Long parkId) {
        parkingService.deleteParkingDetailsById(parkId);
        return "Delete";
    }


    @PutMapping("/{v-id}/parking/{p-id}")
    private Parking updateParkingDetails(@PathVariable() Long vehicleId, @RequestBody Parking parking, @PathVariable("p-id") Long parkId) {
        return parkingService.updateParkingDetails(parking, parkId, vehicleId);
    }

}
