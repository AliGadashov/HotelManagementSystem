package com.gadashov.hotelmanagementsystem.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gadashov.hotelmanagementsystem.model.entity.RoomType;
import jakarta.validation.constraints.NotEmpty;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record CreateRoomRequest(

        @NotEmpty
        String status,
        @NotEmpty
        @JsonProperty("hotel_id")
        Long hotelId,
        @NotEmpty
        @JsonProperty("room_type")
        RoomType roomType

) {
}
