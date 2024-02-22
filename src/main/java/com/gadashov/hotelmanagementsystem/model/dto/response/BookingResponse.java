package com.gadashov.hotelmanagementsystem.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gadashov.hotelmanagementsystem.model.entity.Guest;
import com.gadashov.hotelmanagementsystem.model.entity.Payment;
import com.gadashov.hotelmanagementsystem.model.entity.Room;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record BookingResponse(
        Long id,
        @JsonProperty("total_price")
        BigDecimal totalPrice,
        @JsonProperty("check_in_time")
        LocalDateTime checkInTime,
        @JsonProperty("check_out_time")
        LocalDateTime checkOutTime,
        List<PaymentResponse> payments,
        RoomResponse room,
        GuestResponse guest
) {
}
