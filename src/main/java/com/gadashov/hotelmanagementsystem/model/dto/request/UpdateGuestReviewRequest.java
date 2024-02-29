package com.gadashov.hotelmanagementsystem.model.dto.request;

import com.gadashov.hotelmanagementsystem.model.enums.ReviewType;
import jakarta.validation.constraints.NotEmpty;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 2/26/2024
 * Time: 10:06 AM
 */

public record UpdateGuestReviewRequest(
        @NotEmpty Integer rating,

        @NotEmpty Long hotelId,
        @NotEmpty Long roomId,
        @NotEmpty Long userId,
        @NotEmpty
        ReviewType reviewType
) {
}
