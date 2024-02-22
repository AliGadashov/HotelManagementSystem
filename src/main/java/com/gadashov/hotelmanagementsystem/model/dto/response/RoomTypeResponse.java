package com.gadashov.hotelmanagementsystem.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gadashov.hotelmanagementsystem.model.entity.Room;

import java.math.BigDecimal;
import java.util.List;

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
