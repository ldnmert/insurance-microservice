package com.merteld.sigorta.vehicleservice.service;

import com.merteld.sigorta.vehicleservice.client.PolicyClient;
import com.merteld.sigorta.vehicleservice.dto.CreateVehicleDto;
import com.merteld.sigorta.vehicleservice.dto.PolicyDetailDto;
import com.merteld.sigorta.vehicleservice.model.Vehicle;
import com.merteld.sigorta.vehicleservice.model.VehicleCode;
import com.merteld.sigorta.vehicleservice.repository.VehicleCodeRepository;
import com.merteld.sigorta.vehicleservice.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final PolicyClient policyClient;
    private final VehicleRepository vehicleRepository;
    private final VehicleCodeRepository vehicleCodeRepository;

    public PolicyDetailDto createVehiclePolicy(CreateVehicleDto createVehicleDto, Long customerId, String vehicleCode){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Vehicle vehicle =  CreateVehicleDto.toVehicle(createVehicleDto);
        VehicleCode vehicleCodeObject = vehicleCodeRepository.findByVehicleCode(vehicleCode);

        PolicyDetailDto policyDetail = policyClient.createPolicy("310" ,customerId, vehicleCodeObject.getAmount(), Long.valueOf(auth.getName()) ).getBody();

        vehicle.setPolicyNumber(policyDetail.getPolicyNumber());
        vehicle.setBrand(vehicleCodeObject.getMake());
        vehicle.setModel(vehicleCodeObject.getModel());
        vehicle.setYear(vehicleCodeObject.getYear());
        vehicleRepository.save(vehicle);
        return policyDetail;

    }

}
