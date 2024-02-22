package com.gadashov.hotelmanagementsystem.model.exceptions;

import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import lombok.Getter;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Getter
public class BookingException extends GlobalException {
    public BookingException(Exceptions exceptions) {
        super(exceptions);
    }
}
