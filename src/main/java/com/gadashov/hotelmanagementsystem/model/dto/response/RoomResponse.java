package com.gadashov.hotelmanagementsystem.model.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.gadashov.hotelmanagementsystem.model.entity.Hotel;
import com.gadashov.hotelmanagementsystem.model.entity.RoomType;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record RoomResponse(

        Long id,
        String status,
        Hotel hotel,
        @JsonProperty("room_type")
        RoomTypeResponse roomType
) {
}
