package com.gadashov.hotelmanagementsystem.controller;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreatePaymentRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdatePaymentRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.PaymentResponse;
import com.gadashov.hotelmanagementsystem.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/payment")
public class PaymentController {


    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Void> createPayment(
            @RequestBody CreatePaymentRequest request
    ){
        paymentService.createPayment(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePaymentById(
            @PathVariable Long id,
            @RequestBody UpdatePaymentRequest request
    ){
        paymentService.updatePaymentById(id,request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentById(
            @PathVariable Long id
    ){
        PaymentResponse paymentResponse = paymentService.getPaymentById(id);
        return ResponseEntity.ok().body(paymentResponse);
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> getAllPayment(){
        List<PaymentResponse> paymentResponse = paymentService.getAllPayment();
        return ResponseEntity.ok().body(paymentResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(
            @PathVariable Long id
    ){
        paymentService.deletePayment(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<PaymentResponse>> findPaymentsByBookingId(
            @PathVariable Long bookingId
    ){
        List<PaymentResponse> paymentResponse = paymentService.findPaymentsByBookingId(bookingId);
        return ResponseEntity.ok().body(paymentResponse);
    }


}
