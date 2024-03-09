package com.gadashov.hotelmanagementsystem.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

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
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9]{8,}$")
        String password,
        @JsonProperty("date_of_birth")
        LocalDate dateOfBirth
) {
}
