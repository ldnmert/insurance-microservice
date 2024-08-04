package com.merteld.sigorta.vehicleservice.dto;

import com.merteld.sigorta.vehicleservice.model.Vehicle;
import lombok.Data;

@Data
public class CreateVehicleDto {

    private Integer plateCityCode;
    private String plateCode;
    private String engineNumber;
    private String chassisNumber;


    public static Vehicle toVehicle(CreateVehicleDto dto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setPlateCityCode(dto.getPlateCityCode());
        vehicle.setPlateCode(dto.getPlateCode());

        vehicle.setEngineNumber(dto.getEngineNumber());
        vehicle.setChassisNumber(dto.getChassisNumber());

        return vehicle;

    }



}