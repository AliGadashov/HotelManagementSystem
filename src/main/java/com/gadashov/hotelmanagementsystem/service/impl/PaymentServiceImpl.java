package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.mapper.PaymentMapper;
import com.gadashov.hotelmanagementsystem.model.dto.request.CreatePaymentRequest;
import com.gadashov.hotelmanagementsystem.model.dto.request.UpdatePaymentRequest;
import com.gadashov.hotelmanagementsystem.model.dto.response.PaymentResponse;
import com.gadashov.hotelmanagementsystem.model.entity.Payment;
import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.exceptions.PaymentException;
import com.gadashov.hotelmanagementsystem.repository.PaymentRepository;
import com.gadashov.hotelmanagementsystem.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    @Override
    public void createPayment(CreatePaymentRequest request) {
        Payment payment = paymentMapper.toPayment(request);
        paymentRepository.save(payment);
    }

    @Override
    public void updatePaymentById(Long id, UpdatePaymentRequest request) {
        Payment payment = findPaymentById(id);
        Payment updatedPayment = paymentMapper.updatePayment(payment, request);
        paymentRepository.save(updatedPayment);
    }

    @Override
    public PaymentResponse getPaymentById(Long id) {
        return paymentMapper.toPaymentResponse(findPaymentById(id));
    }

    @Override
    public List<PaymentResponse> getAllPayment() {
        List<Payment> payments = paymentRepository.findAll();
        return payments.stream()
                .map(paymentMapper::toPaymentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.delete(findPaymentById(id));
    }

    @Override
    public Payment findPaymentById(Long id){

        return paymentRepository.findById(id)
                .orElseThrow(() -> new PaymentException(Exceptions.PAYMENT_NOT_FOUND));
    }

    @Override
    public List<PaymentResponse> findPaymentsByBookingId(Long bookingId) {
        List<Payment> payments = paymentRepository.findByBookingId(bookingId);
        return payments.stream()
                .map(paymentMapper::toPaymentResponse)
                .collect(Collectors.toList());
    }


}
