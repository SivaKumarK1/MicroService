package com.shoppingmall.parking.repository;

import com.shoppingmall.parking.entity.Parking;
import com.shoppingmall.parking.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
    List<Parking> findByVehicleDetails(Optional<Vehicle> byId);
}
