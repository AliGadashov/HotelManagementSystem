package com.gadashov.hotelmanagementsystem.model.dto.response;

import java.util.List;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public record ExceptionResponse(
        Integer status,
        List<String> message
) {
}
