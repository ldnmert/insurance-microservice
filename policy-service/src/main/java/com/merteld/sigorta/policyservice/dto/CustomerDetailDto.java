package com.merteld.sigorta.policyservice.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerDetailDto {

    private String id;

    private String identificationNumber;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String city;
    private String district;

}