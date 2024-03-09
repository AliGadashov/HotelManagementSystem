package com.gadashov.hotelmanagementsystem.model.dto.request;

import lombok.Builder;
import lombok.Getter;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 3/9/2024
 * Time: 2:10 PM
 */
@Builder
public record EmailRequest(
        String to,
        String subject,
        String text
) {
}
