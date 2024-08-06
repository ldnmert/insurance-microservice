package com.merteld.sigorta.policyservice.service;

import com.merteld.sigorta.policyservice.dto.PolicyDetailDto;
import com.merteld.sigorta.policyservice.model.Policy;
import com.merteld.sigorta.policyservice.repository.PolicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PolicyService {

   private final PolicyRepository policyRepository;

    public Policy getPolicyByPolicyNumber(String policyNumber) {
        return policyRepository.findByPolicyNumber(policyNumber).get();
    }

    public List<PolicyDetailDto> getPoliciesOfCurrentUser(Long id) {
        return PolicyDetailDto.toDtoList(policyRepository.findByUserId(id));
    }

    public List<PolicyDetailDto> getPoliciesByUserIdAndStatusAndSort(Long id, char status, String sortOption) {

        Sort sort = Sort.by("createdAt").descending(); // Default sort by createdAt descending

        if (sortOption != null) {
            switch (sortOption) {
                case "recent":
                    sort = Sort.by("createdAt").descending();
                    break;
                case "amountAsc":
                    sort = Sort.by("amount").ascending();
                    break;
                case "amountDesc":
                    sort = Sort.by("amount").descending();
                    break;
            }
        }

        if(status == 'H') {
            return PolicyDetailDto.toDtoList(policyRepository.findByUserId(id, sort));
        }
        else {
            return PolicyDetailDto.toDtoList(policyRepository.findByUserIdAndStatus(id, status, sort));
        }
    }



    public List<PolicyDetailDto> getExpiringPolicies(Long userId) {
        LocalDate endDate = LocalDate.now().plusDays(5);
        return PolicyDetailDto.toDtoList(policyRepository.findExpiringPoliciesByUserId(userId, endDate));
    }



    public double getStatusKRatioByUserId(Long userId) {
        long countStatusK = policyRepository.countPoliciesByUserIdAndStatusK(userId);
        long totalCount = policyRepository.countPoliciesByUserId(userId);

        if (totalCount == 0) {
            return 0; // Toplam poliçe sayısı 0 ise oran 0'dır
        }

        double ratio = (countStatusK / (double) totalCount) * 100;
        return ratio;
    }



    public List<PolicyDetailDto> getTop3PoliciesByAmountDesc(Long userId) {
        return PolicyDetailDto.toDtoList(policyRepository.findTop3ByUserIdOrderByAmountDesc(userId));
    }


    public List<Long> getCustomerIdsByUserIds(Long id){
        System.out.println(policyRepository.findDistinctCustomerIdsByUserId(id));
        return policyRepository.findDistinctCustomerIdsByUserId(id);
    }


    public PolicyDetailDto createPolicy(String policyTypeNumber, Long customerId, double amount, Long principal) {

        Policy policy = new Policy();

        policy.setCustomerId(customerId);
        policy.setAmount(amount);
        policy.setUserId(principal);
        policy.setPolicyNumber(generateUniquePolicyNumber());
        policy.setBranchCode(policyTypeNumber);

        return PolicyDetailDto.toDto(policyRepository.save(policy));

    }


    private String generateUniquePolicyNumber() {
        Random random = new Random();
        String policyNumber;
        do {
            policyNumber = String.format("%08d", random.nextInt(100000000));
        } while (policyRepository.existsByPolicyNumber(policyNumber));
        return policyNumber;
    }

    public double changeStatusAndGetAmount(String policyNumber) {
        Policy policy = policyRepository.findByPolicyNumber(policyNumber).orElseThrow(NoSuchElementException::new);
        policy.setStatus('K');
        return policyRepository.save(policy).getAmount();
    }
}
