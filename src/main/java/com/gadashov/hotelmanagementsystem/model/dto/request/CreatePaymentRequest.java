package com.gadashov.hotelmanagementsystem.model.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record CreatePaymentRequest(


        @NotEmpty
        Long bookingId,

        @NotEmpty
        String paymentMethod,

        @NotEmpty
        BigDecimal amount,

        @NotEmpty
        LocalDate paymentDate

        ) {
}
