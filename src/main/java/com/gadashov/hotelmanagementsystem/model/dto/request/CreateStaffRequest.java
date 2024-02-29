package com.gadashov.hotelmanagementsystem.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record CreateStaffRequest(
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
        @JsonProperty("date_of_birth")
        LocalDate dateOfBirth,
        @NotEmpty
        @JsonProperty("hire-date")
        LocalDate hireDate,
        @NotEmpty
        @JsonProperty("hotel_id")
        Long hotelId
) {
}
