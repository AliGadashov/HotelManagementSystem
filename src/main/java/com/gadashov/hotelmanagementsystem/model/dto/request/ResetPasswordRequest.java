package com.gadashov.hotelmanagementsystem.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 2:10 PM
 */

public record ResetPasswordRequest(
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9]{8,}$")
        @JsonProperty("new_password")
        String newPassword,
        @NotBlank
        @JsonProperty("repeat_password")
        String repeatPassword

) {
}
