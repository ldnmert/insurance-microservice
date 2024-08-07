package com.merteld.sigorta.customerservice.controller;

import com.merteld.sigorta.customerservice.client.PolicyClient;
import com.merteld.sigorta.customerservice.dto.CreateCustomerDto;

import com.merteld.sigorta.customerservice.dto.CustomerDetailDto;
import com.merteld.sigorta.customerservice.model.Customer;
import com.merteld.sigorta.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/customer")
@RequiredArgsConstructor
public class  CustomerController {

    @GetMapping("/test")
    public String test(Authentication authentication) {

        System.out.println(authentication.getName());
        return "just testing";

    }

    private final CustomerService customerService;
    private final PolicyClient policyClient;



    @PostMapping
    public ResponseEntity<CustomerDetailDto> createCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
        Customer customer = CreateCustomerDto.toCustomer(createCustomerDto);
        CustomerDetailDto customerDetailDto = customerService.createCustomer(customer);
        return ResponseEntity.ok(customerDetailDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDetailDto> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping("/check-customer-exist")
    public ResponseEntity<CustomerDetailDto> checkCustomerExist(@RequestParam String identificationNumber) {
        Customer customer = customerService.getCustomerByIdentificationNumber(identificationNumber);

        if (customer == null)
            return ResponseEntity.notFound().build();

        else
            return ResponseEntity.ok().body(CustomerDetailDto.toDto(customer));


    }

    @GetMapping("/search")
    public ResponseEntity<CustomerDetailDto> searchCustomer(@RequestParam String identificationNumber) {
        Customer customer = customerService.getCustomerByIdentificationNumber(identificationNumber);
        return ResponseEntity.ok(CustomerDetailDto.toDto(customer));
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDetailDto>> getCustomersByUserId(Authentication authentication) {
        System.out.println(authentication.getPrincipal());
        List<Long> customersIds = policyClient.getCustomerIdsOfUser(Long.valueOf((String) authentication.getPrincipal())).getBody();

        System.out.println(customersIds);
        return ResponseEntity.ok(customerService.getAllCustomersCurrentUser(customersIds));
    }
}
