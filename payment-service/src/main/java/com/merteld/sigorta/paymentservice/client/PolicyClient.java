package com.merteld.sigorta.paymentservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "policy-service", path = "/v1/policy")
public interface PolicyClient {


    @PutMapping("/changeStatus")
    ResponseEntity<Double> changeStatusAndGetAmount(@RequestParam String policyNumber);

}
