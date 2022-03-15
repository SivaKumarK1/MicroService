package com.shoppingmall.parking.serviceImpl;

import com.shoppingmall.parking.entity.Parking;
import com.shoppingmall.parking.entity.Vehicle;
import com.shoppingmall.parking.repository.ParkingRepository;
import com.shoppingmall.parking.repository.VehicleRepository;
import com.shoppingmall.parking.service.ParkingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParkingServiceImpl implements ParkingService {
    private final ParkingRepository parkingRepository;
    private final VehicleRepository vehicleRepository;


    @Override
    public Parking saveDetails(Parking parking, Long vehicleId) {
        Vehicle vehicle = vehicleRepository.getById(vehicleId);
        parking.setVehicleDetails(vehicle);
//        log.info(String.valueOf(parking));
        parkingRepository.save(parking);
//        log.info(String.valueOf(parking));
        log.info("Data Posted to Database with ID: " + parking.getParkId());
        return parking;
    }

    @Override
    public List<Parking> fetchAllParkingDetails(Long vehicleId) {
        log.info("All Data Fetched From Database");
        return parkingRepository.findByVehicleDetails(vehicleRepository.findById(vehicleId));
    }


    @Override
    public List<Parking> fetchAllVehicleParking() {
        log.info("Fetched All order Details ");
        return parkingRepository.findAll();

    }

    //
    @Override
    public Parking fetchParkingDetailsById(Long parkId) {
        Optional<Parking> parking = parkingRepository.findById(parkId);
        if (!parking.isPresent()) {
            log.info("Does Not exists");
        }
        return parking.get();
    }

    @Override
    public void deleteParkingDetailsById(Long parkId) {
        if (parkingRepository.findById(parkId).isEmpty()) {
            log.info("Does Not exists");
//            System.out.println("Does Not Exists");
        } else {
            parkingRepository.deleteById(parkId);
            log.info("Data Deleted from Database with ID: " + parkId);

        }
    }

    @Override
    public Parking updateParkingDetails(Parking parking, Long parkId, Long vehicleId) {
        Optional<Parking> parking2 = parkingRepository.findById(parkId);
        if (!parking2.isPresent()) {
            log.info("Does Not exists Added a new record with ID:" + parking.getParkId());

        }
        log.info("Updated the db with new values ID: " + parking.getParkId());
        return parkingRepository.save(parking);
    }
}


