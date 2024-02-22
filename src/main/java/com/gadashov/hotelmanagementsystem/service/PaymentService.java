package com.gadashov.hotelmanagementsystem.service;

import com.gadashov.hotelmanagementsystem.model.dto.request.CreatePaymentRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdatePaymentRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.PaymentResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Payment;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public interface PaymentService {

    void createPayment(CreatePaymentRequest request);
    void updatePaymentById(Long id, UpdatePaymentRequest request);
    PaymentResponse getPaymentById(Long id);

    void deletePayment(Long id);

    List<PaymentResponse> getAllPayment();

    Payment findPaymentById(Long id);

    List<PaymentResponse> findPaymentsByBookingId(Long bookingId);
}
