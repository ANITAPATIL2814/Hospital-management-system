package com.demo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private int statusCode;
    private String message;

    public ErrorMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

   
}
