package com.merteld.sigorta.paymentservice.service;

import com.merteld.sigorta.paymentservice.client.PolicyClient;
import com.merteld.sigorta.paymentservice.dto.PaymentDto;
import com.merteld.sigorta.paymentservice.dto.RequestPaymentDto;
import com.merteld.sigorta.paymentservice.model.Payment;
import com.merteld.sigorta.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PolicyClient policyClient;

    public PaymentDto createPaymentEnablePolicy(RequestPaymentDto requestPaymentDto, String policyNumber) {

        Payment payment = RequestPaymentDto.toPayment(requestPaymentDto);

        Double amount = policyClient.changeStatusAndGetAmount(policyNumber).getBody();

        payment.setAmount(amount);
        payment.setPolicyNumber(policyNumber);
        paymentRepository.save(payment);

        return PaymentDto.toDto(payment);

    }
}
