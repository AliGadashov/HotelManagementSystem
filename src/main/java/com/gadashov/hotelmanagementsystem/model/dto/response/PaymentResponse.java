package com.gadashov.hotelmanagementsystem.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record PaymentResponse(

        Long id,
        @JsonProperty("booking_id")
        Long bookingId,
        @JsonProperty("payment_method")
        String paymentMethod,
        BigDecimal amount,
        @JsonProperty("payment_date")
        LocalDate paymentDate

) {
}
