package com.merteld.sigorta.vehicleservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;

    private String brand;
    private String model;
    private String year;


    private String engineNumber;
    private String chassisNumber;
    private Integer plateCityCode;
    private String plateCode;


    private LocalDate createdAt;


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }
}
