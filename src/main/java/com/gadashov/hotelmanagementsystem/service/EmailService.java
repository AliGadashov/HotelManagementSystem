package com.gadashov.hotelmanagementsystem.service;

import com.gadashov.hotelmanagementsystem.model.dto.request.EmailRequest;
import jakarta.mail.MessagingException;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 1:21 PM
 */

public interface EmailService {
    void sendEmail(EmailRequest request) throws MessagingException;
}
