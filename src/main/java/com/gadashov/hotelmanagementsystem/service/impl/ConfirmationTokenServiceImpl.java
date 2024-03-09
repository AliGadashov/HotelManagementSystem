package com.gadashov.hotelmanagementsystem.service.impl;

import com.gadashov.hotelmanagementsystem.model.entity.ConfirmationToken;
import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import com.gadashov.hotelmanagementsystem.model.exceptions.GlobalException;
import com.gadashov.hotelmanagementsystem.repository.ConfirmationTokenRepository;
import com.gadashov.hotelmanagementsystem.service.ConfirmationOtpService;
import com.gadashov.hotelmanagementsystem.service.ConfirmationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 2:44 PM
 */

@Service
@RequiredArgsConstructor
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
    private final ConfirmationTokenRepository tokenRepository;
    @Override
    public ConfirmationToken getConfirmationToken(String token) {
        return tokenRepository.findByToken(token)
                .orElseThrow(() -> new GlobalException(Exceptions.TOKEN_NOT_FOUND));
    }
}
