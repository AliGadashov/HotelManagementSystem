package com.gadashov.hotelmanagementsystem.service;

import com.gadashov.hotelmanagementsystem.model.entity.ConfirmationToken;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 2:40 PM
 */

public interface ConfirmationTokenService {
    ConfirmationToken getConfirmationToken(String token);
}
