package com.gadashov.hotelmanagementsystem.model.exceptions;

import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 * Date: 2/26/2024
 * Time: 10:26 AM
 */

public class GuestReviewException extends GlobalException {
    public GuestReviewException(Exceptions exceptions) {
        super(exceptions);
    }
}
