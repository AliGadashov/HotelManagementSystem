package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.model.dto.request.EmailRequest;
import com.gadashov.hotelmanagementsystem.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 1:22 PM
 */
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    public final JavaMailSender mailSender;

    @Override
    public void sendEmail(EmailRequest request) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        mimeMessageHelper.setFrom("gadashovali13@gmail.com");
        mimeMessageHelper.setTo(request.to());
        mimeMessageHelper.setSubject(request.subject());
        mimeMessageHelper.setText(request.text() , true);

        mailSender.send(mimeMessage);
    }
}
