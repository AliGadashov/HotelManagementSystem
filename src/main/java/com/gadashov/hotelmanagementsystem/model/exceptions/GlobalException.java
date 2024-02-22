package com.gadashov.hotelmanagementsystem.model.exceptions;

import com.gadashov.hotelmanagementsystem.model.enums.Exceptions;
import lombok.Getter;

/**
 * Author: Ali Gadashov
 * Version: v1.0
 */

@Getter
public class GlobalException extends RuntimeException {
    private final Exceptions exceptions;
    public GlobalException(Exceptions exceptions) {
        super(exceptions.getMessage());
        this.exceptions = exceptions;
    }

}
