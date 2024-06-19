package com.infinity.bytes.WhatsappApiService.exception;


public class DataRepeatedException extends  RuntimeException{
    public DataRepeatedException() {
    }

    public DataRepeatedException(String message) {
        super(message);
    }

    public DataRepeatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataRepeatedException(Throwable cause) {
        super(cause);
    }
}
