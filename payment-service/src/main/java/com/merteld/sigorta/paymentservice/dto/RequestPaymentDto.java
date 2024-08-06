package com.merteld.sigorta.paymentservice.dto;

import com.merteld.sigorta.paymentservice.model.Payment;
import lombok.Data;

@Data
public class RequestPaymentDto {

    private String cardNumber;
    private String cvv;

    private String cardHolder;
    private String expiryDate;

    public static Payment toPayment(RequestPaymentDto dto) {
        Payment payment = new Payment();
        payment.setCardNumber(dto.getCardNumber());
        payment.setCardHolder(dto.getCardHolder());
        payment.setExpiryDate(dto.getExpiryDate());
        payment.setCvv(dto.getCvv());
        return payment;
    }

}
