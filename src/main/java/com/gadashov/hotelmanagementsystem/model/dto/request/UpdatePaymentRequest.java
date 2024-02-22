package com.gadashov.hotelmanagementsystem.model.dto.request;

import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record UpdatePaymentRequest(
        @NotEmpty
        String paymentMethod,

        @NotEmpty
        BigDecimal amount,

        @NotEmpty
        LocalDate paymentDate

) {
}
