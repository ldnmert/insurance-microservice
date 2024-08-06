package com.merteld.sigorta.paymentservice.dto;

import com.merteld.sigorta.paymentservice.model.Payment;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PaymentDto {

    private String cardNumber;
    private String cvv;

    private String cardHolder;
    private String expiryDate;
    private LocalDateTime createdAt;

    public static PaymentDto toDto(Payment payment) {
        PaymentDto dto = new PaymentDto();
        dto.setCardNumber(payment.getCardNumber());
        dto.setCvv(payment.getCvv());
        dto.setCardHolder(payment.getCardHolder());
        dto.setExpiryDate(payment.getExpiryDate());
        dto.setCreatedAt(payment.getCreatedAt());
        return dto;
    }



}
