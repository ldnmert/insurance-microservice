package com.merteld.sigorta.customerservice.service;


import com.merteld.sigorta.customerservice.dto.CustomerDetailDto;
import com.merteld.sigorta.customerservice.model.Customer;
import com.merteld.sigorta.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


import com.merteld.sigorta.customerservice.model.Customer;

import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;

    public Customer getCustomerByIdentificationNumber(String identificationNumber) {
        return customerRepository.findByIdentificationNumber(identificationNumber)
                .orElse(null);
    }

    public CustomerDetailDto createCustomer(Customer customer) {
        return CustomerDetailDto.toDto(customerRepository.save(customer));
    }

    public List<CustomerDetailDto> getAllCustomersCurrentUser(List<Long> customerIds) {
        System.out.println(customerIds + "mert the");
        System.out.println(customerRepository.findAllByIds(customerIds) + "mert the");
        return CustomerDetailDto.toDtoList(customerRepository.findAllByIds(customerIds));
    }

    public CustomerDetailDto getCustomerById(Long id) {

        return CustomerDetailDto.toDto(customerRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }
}
