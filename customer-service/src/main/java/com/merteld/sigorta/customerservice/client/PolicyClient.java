package com.merteld.sigorta.customerservice.client;

import jakarta.websocket.OnOpen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "policyClient", url = "http://localhost:7865/v1/policy")
public interface PolicyClient {

    @GetMapping("/customerIdsOfUser/{userId}")
    ResponseEntity<List<Long>> getCustomerIdsOfUser(@PathVariable Long userId);

}
