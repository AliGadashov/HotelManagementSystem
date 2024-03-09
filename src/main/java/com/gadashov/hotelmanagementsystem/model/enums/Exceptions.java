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
    PAYMENT_NOT_FOUND("Payment not found!", HttpStatus.NOT_FOUND),
    GUEST_REVIEW_NOT_FOUND("Guest review not found!", HttpStatus.NOT_FOUND ),
    GUEST_REVIEW_NOT_FOUND_WITH_ID("Guest review not found with id", HttpStatus.NOT_FOUND  ),
    GUEST_REVIEW_ALREADY_EXIST("Guest review already exist!", HttpStatus.MULTI_STATUS),
    OTP_NOT_FOUND("Otp not found!", HttpStatus.NOT_FOUND),
    TOKEN_NOT_FOUND("Token not found!", HttpStatus.NOT_FOUND),
    PASSWORDS_NOT_MATCH("Passwords  not matches",HttpStatus.BAD_REQUEST );


    private final String message;
    private final HttpStatus status;
    Exceptions(String message,HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
