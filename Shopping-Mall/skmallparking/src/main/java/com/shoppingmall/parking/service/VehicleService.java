package com.shoppingmall.parking.service;

import com.shoppingmall.parking.entity.Parking;
import com.shoppingmall.parking.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle saveDetails(Vehicle vehicle);

    List<Vehicle> fetchAllVechileDetails();

    Vehicle fetchVechileDetailsById(Long vehicleId);

    void deleteParkingDetailsById(Long vehicleId);

    Vehicle updateParkingDetails(Vehicle vehicle, Long vehicleId);
}
