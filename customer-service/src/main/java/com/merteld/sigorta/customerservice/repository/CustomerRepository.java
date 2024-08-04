package com.merteld.sigorta.customerservice.repository;

import com.merteld.sigorta.customerservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByIdentificationNumber(String identificationNumber);

    List<Customer> findTop20ByOrderByCreatedAtDesc();

    @Query("SELECT c FROM Customer c WHERE c.id IN :ids")
    List<Customer> findAllByIds(@Param("ids") List<Long> ids);

}
