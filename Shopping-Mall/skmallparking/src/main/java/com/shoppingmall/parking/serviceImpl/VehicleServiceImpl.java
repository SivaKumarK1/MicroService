package com.shoppingmall.parking.serviceImpl;

import com.shoppingmall.parking.entity.Vehicle;
import com.shoppingmall.parking.repository.VehicleRepository;
import com.shoppingmall.parking.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveDetails(Vehicle vehicle) {
//        log.info(String.valueOf(vehicle));
        vehicleRepository.save(vehicle);
//        log.info(String.valueOf(vehicle));
        log.info("Data Posted to Database with ID: " + vehicle.getVehicleId());
        return vehicle;
    }

    @Override
    public List<Vehicle> fetchAllVechileDetails() {
        log.info("All Data Fetched From Database");
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle fetchVechileDetailsById(Long vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if (!vehicle.isPresent()) {
            log.info("Does Not exists");
        }
        return vehicle.get();
    }

    @Override
    public void deleteParkingDetailsById(Long vehicleId) {
        if (vehicleRepository.findById(vehicleId).isEmpty()) {
            log.info("Does Not exists");
//            System.out.println("Does Not Exists");
        } else {
            vehicleRepository.deleteById(vehicleId);
            log.info("Data Deleted from Database with ID: " + vehicleId);

        }
    }

    @Override
    public Vehicle updateParkingDetails(Vehicle vehicle, Long vehicleId) {
        Optional<Vehicle> vehicle2 = vehicleRepository.findById(vehicleId);
        if (!vehicle2.isPresent()) {
            log.info("Does Not exists Added a new record with ID:" + vehicle.getVehicleId());

        }
        log.info("Updated the db with new values ID: " + vehicle.getVehicleId());
        return vehicleRepository.save(vehicle);
    }
}

