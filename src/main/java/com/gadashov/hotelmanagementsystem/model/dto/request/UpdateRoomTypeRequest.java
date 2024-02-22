package com.gadashov.hotelmanagementsystem.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record UpdateRoomTypeRequest(

        @NotEmpty
        String name,
        @NotEmpty
        String description,
        @NotEmpty
        Integer capacity,
        @NotEmpty
        @JsonProperty("price_per_night")
        BigDecimal pricePerNight

) {
}
