package com.merteld.sigorta.vehicleservice.repository;

import com.merteld.sigorta.vehicleservice.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
