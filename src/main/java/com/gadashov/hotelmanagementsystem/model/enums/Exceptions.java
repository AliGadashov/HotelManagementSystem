package com.gadashov.hotelmanagementsystem.model.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Getter
public enum Exceptions {
    GUEST_NOT_FOUND("Guest not found!", HttpStatus.NOT_FOUND),
    ROOM_NOT_FOUND("Room not found!", HttpStatus.NOT_FOUND),
    ROOM_TYPE_NOT_FOUND("Room type not found!", HttpStatus.NOT_FOUND),
    HOTEL_NOT_FOUND("Hotel not found!", HttpStatus.NOT_FOUND),
    STAFF_NOT_FOUND("Staff not found!", HttpStatus.NOT_FOUND),
    BOOKING_NOT_FOUND("Booking not found!", HttpStatus.NOT_FOUND),
    PAYMENT_NOT_FOUND("Payment not found!", HttpStatus.NOT_FOUND);


    private final String message;
    private final HttpStatus status;
    Exceptions(String message,HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
