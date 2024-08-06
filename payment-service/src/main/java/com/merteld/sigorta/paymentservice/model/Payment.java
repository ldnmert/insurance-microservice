package com.merteld.sigorta.paymentservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;

    private double amount;
    private LocalDateTime createdAt;

    private String cardNumber;
    private String cvv;
    private String expiryDate;
    private String cardHolder;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}