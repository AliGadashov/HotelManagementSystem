package com.gadashov.hotelmanagementsystem.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gadashov.hotelmanagementsystem.model.enums.ReviewType;
import jakarta.validation.constraints.NotEmpty;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 2/26/2024
 * Time: 10:07 AM
 */

public record GuestReviewResponse(


        Long id,
        @NotEmpty
        Integer rating,

        @JsonProperty("hotel_id")
        Long hotelId,

        @JsonProperty("room_id")
        Long roomId,

        @JsonProperty("guest_id")
        Long guestId,
        @JsonProperty("review_type")
        ReviewType reviewType


) {
}
