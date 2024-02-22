package com.gadashov.hotelmanagementsystem.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record CreateGuestRequest(
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName,
        String address,
        String phone,
        String email,
        @JsonProperty("date_of_birth")
        LocalDate dateOfBirth
) {
}
