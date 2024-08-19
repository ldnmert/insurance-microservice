package com.merteld.sigorta.customerservice.repository;

import com.merteld.sigorta.customerservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByIdentificationNumber(String identificationNumber);

    @Query("{ '_id': { '$in': ?0 } }")
    List<Customer> findAllByIds(List<String> ids);

    List<Customer> findTop20ByOrderByCreatedAtDesc();
}

