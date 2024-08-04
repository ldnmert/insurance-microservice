package com.merteld.sigorta.vehicleservice.client;

import com.merteld.sigorta.vehicleservice.dto.PolicyDetailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "policy-service", path = "/v1/policy")
public interface PolicyClient {


    @PostMapping
    ResponseEntity<PolicyDetailDto> createPolicy(String policyTypeNumber, Long customerId, double amount, Long principal);

}
