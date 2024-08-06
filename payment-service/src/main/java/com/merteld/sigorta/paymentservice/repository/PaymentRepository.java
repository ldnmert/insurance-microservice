package com.merteld.sigorta.paymentservice.repository;

import com.merteld.sigorta.paymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {



}
