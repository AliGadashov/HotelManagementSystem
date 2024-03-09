package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.helper.ConfirmationOtpServiceHelper;
import com.gadashov.hotelmanagementsystem.helper.EmailServiceHelper;
import com.gadashov.hotelmanagementsystem.model.dto.request.EmailRequest;
import com.gadashov.hotelmanagementsystem.model.entity.ConfirmationOtp;
import com.gadashov.hotelmanagementsystem.model.entity.Guest;
import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.exceptions.GlobalException;
import com.gadashov.hotelmanagementsystem.repository.ConfirmationOtpRepository;
import com.gadashov.hotelmanagementsystem.service.ConfirmationOtpService;
import com.gadashov.hotelmanagementsystem.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 2:42 PM
 */

@Service
@RequiredArgsConstructor
public class ConfirmationOtpServiceImpl implements ConfirmationOtpService {

    private final ConfirmationOtpRepository otpRepository;
    private final ConfirmationOtpServiceHelper otpServiceHelper;
    private final EmailServiceHelper emailServiceHelper;
    private final EmailService emailService;

    @Value("${application.constant.minute}")
    Long minute;

    @Override
    public ConfirmationOtp getConfirmationOtp(Integer otp) {
        return otpRepository.findByOtp(otp)
                .orElseThrow(() -> new GlobalException(Exceptions.OTP_NOT_FOUND));
    }

    @Override
    @SneakyThrows
    public void createdOtpSentToEmail(Guest guest){
        ConfirmationOtp confirmationOtp = otpServiceHelper.getConfirmationOtpBuild(guest, minute);
        otpRepository.save(confirmationOtp);
        EmailRequest emailRequest = emailServiceHelper.sendEmailToResetPassword(guest, confirmationOtp.getOtp());
        emailService.sendEmail(emailRequest);
    }
}
