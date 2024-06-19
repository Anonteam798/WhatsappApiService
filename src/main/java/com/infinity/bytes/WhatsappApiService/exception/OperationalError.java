package com.infinity.bytes.WhatsappApiService.exception;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class OperationalError extends RuntimeException{
    private static final Logger log = LoggerFactory.getLogger(OperationalError.class);

    public OperationalError() {
    }

    public OperationalError(String message) {

        super(message);
    }

    public OperationalError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
