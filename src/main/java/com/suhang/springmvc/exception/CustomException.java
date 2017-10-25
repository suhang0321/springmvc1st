package com.suhang.springmvc.exception;

/**
 * @author hang.su
 * @since 2017-10-25 8:32
 */
public class CustomException extends Exception {
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {

        return message;
    }
}
