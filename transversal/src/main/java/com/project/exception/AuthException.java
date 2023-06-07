package com.project.exception;

public class AuthException extends BaseException {
    public AuthException(String technicalMessage, String humanMessage) {
        super(technicalMessage, humanMessage);
    }
}
