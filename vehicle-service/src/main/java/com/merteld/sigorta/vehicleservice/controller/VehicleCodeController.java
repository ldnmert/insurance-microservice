package com.merteld.sigorta.vehicleservice.controller;

import com.merteld.sigorta.vehicleservice.dto.VehicleDetailsDto;
import com.merteld.sigorta.vehicleservice.service.VehicleCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/vehicleCode")
@RequiredArgsConstructor
public class VehicleCodeController {

    private final VehicleCodeService vehicleCodeService;

    @GetMapping("/vehicle-code")
    public ResponseEntity<VehicleDetailsDto> getVehicleDetails(
            @RequestParam String year,
            @RequestParam String make,
            @RequestParam String model) {
        VehicleDetailsDto details = vehicleCodeService.getVehicleDetails(year, make, model);
        return ResponseEntity.ok(details);
    }


    @GetMapping("/years")
    public ResponseEntity<List<String>> getYears() {
        List<String> years = vehicleCodeService.getAllYears();
        return ResponseEntity.ok(years);
    }

    @GetMapping("/makes")
    public ResponseEntity<List<String>> getMakes() {
        List<String> makes = vehicleCodeService.getAllMakes();
        return ResponseEntity.ok(makes);
    }

    @GetMapping("/models")
    public ResponseEntity<List<String>> getModels(@RequestParam String make) {
        List<String> models = vehicleCodeService.getModelsByMake(make);
        return ResponseEntity.ok(models);
    }

}
