package com.gadashov.hotelmanagementsystem.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
