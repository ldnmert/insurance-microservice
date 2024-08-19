package com.merteld.sigorta.policyservice.client;

import com.merteld.sigorta.policyservice.dto.CustomerDetailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "customer-service", path = "/v1/customer")
public interface CustomerClient {

    @GetMapping("/{id}")
    ResponseEntity<CustomerDetailDto> getCustomerById(@PathVariable String id);

}
