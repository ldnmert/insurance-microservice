package com.merteld.sigorta.paymentservice.controller;

import com.merteld.sigorta.paymentservice.dto.PaymentDto;
import com.merteld.sigorta.paymentservice.dto.RequestPaymentDto;
import com.merteld.sigorta.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;


    @PostMapping
    public ResponseEntity<PaymentDto> createPaymentEnablePolicy(@RequestBody RequestPaymentDto requestPaymentDto, String policyNumber){
        return ResponseEntity.ok(paymentService.createPaymentEnablePolicy(requestPaymentDto, policyNumber));
    }
}
