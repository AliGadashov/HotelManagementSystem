package com.gadashov.hotelmanagementsystem.helper;

import com.gadashov.hotelmanagementsystem.model.entity.ConfirmationToken;
import com.gadashov.hotelmanagementsystem.model.entity.Guest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 1:32 PM
 */
@Service
@RequiredArgsConstructor
public class ConfirmationTokenServiceHelper {
    public ConfirmationToken getConfirmationTokenBuild(Guest guest){
        String token = UUID.randomUUID().toString();

        return ConfirmationToken.builder()
                .guest(guest)
                .token(token)
                .build();
    }
}
