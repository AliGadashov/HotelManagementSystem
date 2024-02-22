package com.gadashov.hotelmanagementsystem.model.exceptions;

import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

public class HotelException extends GlobalException {
    public HotelException(Exceptions exceptions) {
        super(exceptions);
    }
}
