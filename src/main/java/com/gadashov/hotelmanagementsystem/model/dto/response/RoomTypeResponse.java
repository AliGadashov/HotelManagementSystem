package com.gadashov.hotelmanagementsystem.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record RoomTypeResponse(

        Long id,
        String name,
        String description,
        Integer capacity,
        @JsonProperty("price_per_night")
        BigDecimal pricePerNight

) {
}
