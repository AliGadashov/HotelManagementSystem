package com.gadashov.hotelmanagementsystem.service;

import com.gadashov.hotelmanagementsystem.model.entity.ConfirmationOtp;
import com.gadashov.hotelmanagementsystem.model.entity.Guest;
import jakarta.mail.MessagingException;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 2:40 PM
 */

public interface ConfirmationOtpService {
    ConfirmationOtp getConfirmationOtp(Integer otp);
    void createdOtpSentToEmail(Guest guest);
}
