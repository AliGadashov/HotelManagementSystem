package com.gadashov.hotelmanagementsystem.helper;

import com.gadashov.hotelmanagementsystem.model.entity.ConfirmationOtp;
import com.gadashov.hotelmanagementsystem.model.entity.Guest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 3:25 PM
 */

@Service
@RequiredArgsConstructor
public class ConfirmationOtpServiceHelper {

    public ConfirmationOtp getConfirmationOtpBuild(Guest guest, Long minute){
        Random random = new Random();
        int otp = random.nextInt(1000, 9999);

        return ConfirmationOtp.builder()
                .guest(guest)
                .otp(otp)
                .expiredTime(LocalDateTime.now().plusMinutes(minute))
                .build();
    }

}
