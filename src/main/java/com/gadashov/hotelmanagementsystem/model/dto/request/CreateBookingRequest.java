package com.gadashov.hotelmanagementsystem.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gadashov.hotelmanagementsystem.model.entity.Guest;
import com.gadashov.hotelmanagementsystem.model.entity.Room;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record CreateBookingRequest(

        @NotEmpty
        @JsonProperty("total_price")
        BigDecimal totalPrice,
        @NotEmpty
        Room room,
        @NotEmpty
        Guest guest

) {
}
