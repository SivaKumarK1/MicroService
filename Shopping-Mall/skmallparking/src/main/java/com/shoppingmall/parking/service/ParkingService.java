package com.shoppingmall.parking.service;

import com.shoppingmall.parking.entity.Parking;

import java.util.List;

public interface ParkingService {
    Parking saveDetails(Parking parking, Long vehicleId);

    List<Parking> fetchAllParkingDetails(Long vehicleId);

    Parking fetchParkingDetailsById(Long parkId);

    void deleteParkingDetailsById(Long parkId);

    Parking updateParkingDetails(Parking parking, Long parkId, Long vehicleId);

    List<Parking> fetchAllVehicleParking();
}
