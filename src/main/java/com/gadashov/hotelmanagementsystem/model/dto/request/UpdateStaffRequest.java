package com.gadashov.hotelmanagementsystem.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record UpdateStaffRequest(

        @NotEmpty
        @JsonProperty("first_name")
        String firstName,
        @NotEmpty
        @JsonProperty("last_name")
        String lastName,
        @NotEmpty
        String position,
        @NotEmpty
        String phone,
        @NotEmpty
        String email,
        @NotEmpty
        BigDecimal salary,
        @NotEmpty
        @JsonProperty("hotel_id")
        Long hotelId

) {
}
