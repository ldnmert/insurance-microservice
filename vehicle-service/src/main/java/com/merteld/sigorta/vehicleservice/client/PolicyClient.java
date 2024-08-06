package com.merteld.sigorta.vehicleservice.client;

import com.merteld.sigorta.vehicleservice.dto.PolicyDetailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "policy-service", path = "/v1/policy")
public interface PolicyClient {


    @PostMapping
    ResponseEntity<PolicyDetailDto> createPolicy(@RequestParam
                                                 String policyTypeNumber,
                                                 @RequestParam
                                                 Long customerId,
                                                 @RequestParam
                                                 double amount,
                                                 @RequestParam
                                                 Long principal);

}
