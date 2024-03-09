package com.gadashov.hotelmanagementsystem.helper;

import com.gadashov.hotelmanagementsystem.model.dto.request.EmailRequest;
import com.gadashov.hotelmanagementsystem.model.entity.Guest;
import com.gadashov.hotelmanagementsystem.model.enums.SubjectType;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 1:39 PM
 */
@Service
@RequiredArgsConstructor
public class EmailServiceHelper {


    @Value("${spring.application.mail.http}")
    String http;
    @Value("${spring.application.mail.host}")
    String host;
    @Value("${spring.application.mail.confirmation}")
    String confirmation;
    @Value("${spring.application.mail.reset-password}")
    String resetPassword;
    @Value("${spring.application.mail.username}")
    String username;
    @Value("${spring.application.mail.otp}")
    String otp;

    public EmailRequest sendEmailToVerify(Guest guest, String token){
        String url = http + host + getServerPort() +confirmation + token;

        return EmailRequest.builder()
                .to(guest.getEmail())
                .subject(SubjectType.REGISTRATION.name())
                .text("<p> Hi, " + guest.getLastName() + " " + guest.getFirstName()
                        + ", </p>" +
                        "<p>Thank you for registration with us," +
                        "Please, follow the link below to complete your registration.</p>" +
                        "<a href=\"" + url + "\">Verify your email to activate your account</a>" +
                        "<p> Thank you <br> Guests Registration Portal Service</p>")
                .build();
    }

    public EmailRequest sendEmailToResetPassword(Guest guest,Integer otp){
        String url = http + host + getServerPort() + resetPassword
                + username + guest.getEmail() + "&" + this.otp + "=" + otp;

        return EmailRequest.builder()
                .to(guest.getEmail())
                .subject(SubjectType.FORGET_PASSWORD.name())
                .text("<p> Hi, " + guest.getLastName() + " " + guest.getFirstName()
                        + ", </p>" +
                        "<p>Thank you for reset password with us," +
                        "Please, follow the link below to complete your reset password.</p>" +
                        "<a href=\"" + url + "\">Verify your email to activate your account</a>" +
                        "<p> Thank you <br> Guests Reset Password Portal Service</p>")
                .build();
    }


    private String getServerPort() {
        HttpServletRequest request = ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest();

        return ":" + request.getServerPort();
    }



}
