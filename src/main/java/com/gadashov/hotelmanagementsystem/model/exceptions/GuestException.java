package com.gadashov.hotelmanagementsystem.model.exceptions;

import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public class GuestException extends GlobalException {

    public GuestException(Exceptions exceptions) {
        super(exceptions);
    }
}
