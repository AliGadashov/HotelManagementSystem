package com.gadashov.hotelmanagementsystem.model.dto.request;

import jakarta.validation.constraints.NotEmpty;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record CreateHotelRequest(

        @NotEmpty
        String name,
        @NotEmpty
        String address,
        @NotEmpty
        String phone,
        @NotEmpty
        String email,
        @NotEmpty
        Integer stars

) {
}
