package com.shoppingmall.parking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {
    @Id
    @SequenceGenerator(name = "seq", sequenceName = "oracle_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long vehicleId;
    private String vehicleName;
    private String ownerName;
    private String ownerPhone;
    @OneToMany(cascade = {CascadeType.ALL, CascadeType.REMOVE}, mappedBy = "vehicleDetails")
    private List<Parking> parkingDetails;
}
