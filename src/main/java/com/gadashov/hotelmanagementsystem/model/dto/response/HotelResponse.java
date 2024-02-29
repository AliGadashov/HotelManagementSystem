package com.gadashov.hotelmanagementsystem.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record HotelResponse(
        Long id,
        String name,
        String address,
        String phone,
        String email,
        Integer stars,
        @JsonProperty("check_in_time")
        LocalDateTime checkInTime,
        @JsonProperty("check_out_time")
        LocalDateTime checkOutTime,
        List<StaffResponse> staffs,
        List<RoomResponse> rooms,
        List<GuestResponse> guests
) {
}
