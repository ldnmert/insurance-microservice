package com.merteld.sigorta.policyservice.controller;

import com.merteld.sigorta.policyservice.dto.PolicyDetailDto;
import com.merteld.sigorta.policyservice.model.Policy;
import com.merteld.sigorta.policyservice.service.PolicyService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/policy")
@RequiredArgsConstructor
public class PolicyController {


    private final PolicyService policyService;

    @PostMapping
    ResponseEntity<PolicyDetailDto> createPolicy(String policyTypeNumber, Long customerId, double amount, Long principal){

       return ResponseEntity.ok(policyService.createPolicy(policyTypeNumber ,customerId, amount, principal));

    }


    @GetMapping("/policies-of-user")
    public ResponseEntity<List<PolicyDetailDto>> getPoliciesOfUser(Authentication authentication) {

        List<PolicyDetailDto> policiesDetailDtos = policyService.getPoliciesOfCurrentUser((Long) authentication.getPrincipal());
        return ResponseEntity.ok(policiesDetailDtos);
    }

    @GetMapping("/search-policy-number")
    public ResponseEntity<PolicyDetailDto> getPolicyOfCurrentUser(Authentication authentication, @RequestParam String policyNumber) {
        System.out.println("qww");
        Policy policy = policyService.getPolicyByPolicyNumber(policyNumber);

        if(policy.getUserId() == (Long) authentication.getPrincipal()) {
            return ResponseEntity.ok(PolicyDetailDto.toDto(policy));
        }

        else
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
    }


    @GetMapping("/filter-and-sort")
    public ResponseEntity<List<PolicyDetailDto>> getFilterByStatus(@RequestParam char status, Authentication authentication, @RequestParam String sortOption) {
        return ResponseEntity.ok(policyService.getPoliciesByUserIdAndStatusAndSort((Long) authentication.getPrincipal(), status, sortOption));

    }

    @GetMapping("/expiring-policies")
    public ResponseEntity<List<PolicyDetailDto>> getExpiringPolicies(Authentication authentication) {
        return ResponseEntity.ok(policyService.getExpiringPolicies((Long) authentication.getPrincipal()));
    }

    @GetMapping("/status-ratio")
    public ResponseEntity<Double> getPolicyRate(Authentication authentication) {
        double ratio = policyService.getStatusKRatioByUserId((Long) authentication.getPrincipal());
        return ResponseEntity.ok(ratio);
    }

    @GetMapping("/top-three-sell")
    public ResponseEntity<List<PolicyDetailDto>> getTopThreeSellPolicy(Authentication authentication) {
        return ResponseEntity.ok(policyService.getTop3PoliciesByAmountDesc((Long) authentication.getPrincipal()));
    }

    @GetMapping("/customerIdsOfUser/{userId}")
    public ResponseEntity<List<Long>> getCustomerIdsOfUser(@PathVariable Long userId, Authentication authentication) {
//        System.out.println(authentication.getPrincipal());
        return ResponseEntity.ok(policyService.getCustomerIdsByUserIds(userId));
    }








}
