package com.merteld.sigorta.vehicleservice.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class PolicyDetailDto {

    private String branchCode;
    private double amount;
    private LocalDate startDate;
    private char status;
    private LocalDate endDate;
    private String policyNumber;

}
