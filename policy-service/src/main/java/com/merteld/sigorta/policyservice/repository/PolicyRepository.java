package com.merteld.sigorta.policyservice.repository;

import com.merteld.sigorta.policyservice.model.Policy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    Optional<Policy> findByPolicyNumber(String policyNumber);

    List<Policy> findByUserId(Long userId);

    List<Policy> findByUserIdAndStatus(Long userId, char status, Sort sort);


    @Query("SELECT p FROM Policy p WHERE p.userId = :userId AND p.endDate <= :endDate")
    List<Policy> findExpiringPoliciesByUserId(@Param("userId") Long userId, @Param("endDate") LocalDate endDate);

    @Query("SELECT COUNT(p) FROM Policy p WHERE p.userId = :userId AND p.status = 'K'")
    long countPoliciesByUserIdAndStatusK(@Param("userId") Long userId);

    @Query("SELECT COUNT(p) FROM Policy p WHERE p.userId = :userId")
    long countPoliciesByUserId(@Param("userId") Long userId);

    List<Policy> findTop3ByUserIdOrderByAmountDesc(Long userId);

    List<Policy> findByUserId(Long userId, Sort sort);

    @Query("SELECT p.customerId FROM Policy p WHERE p.userId = :userId")
    List<Long> findCustomerIdsByUserId(@Param("userId") Long userId);

    boolean existsByPolicyNumber(String policyNumber);


}
