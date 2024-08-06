package com.merteld.sigorta.vehicleservice.controller;

import com.merteld.sigorta.vehicleservice.dto.CreateVehicleDto;
import com.merteld.sigorta.vehicleservice.dto.PolicyDetailDto;
import com.merteld.sigorta.vehicleservice.model.Vehicle;
import com.merteld.sigorta.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;


    @PostMapping
    public ResponseEntity<PolicyDetailDto> createVehicle(@RequestBody CreateVehicleDto createVehicleDto, @RequestParam Long customerId, @RequestParam String vehicleCode) {

        return ResponseEntity.ok((vehicleService.createVehiclePolicy(createVehicleDto, customerId, vehicleCode)));


    }

}
