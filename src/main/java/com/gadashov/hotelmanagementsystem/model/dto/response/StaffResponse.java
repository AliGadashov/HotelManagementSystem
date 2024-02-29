package com.gadashov.hotelmanagementsystem.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record StaffResponse(
        Long id,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        String position,
        String phone,
        String email,
        BigDecimal salary,
        @JsonProperty("date_of_birth")
        LocalDate dateOfBirth,
        @JsonProperty("hire-date")
        LocalDate hireDate
) {
}
