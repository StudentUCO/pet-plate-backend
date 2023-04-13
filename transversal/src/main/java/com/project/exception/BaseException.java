package com.project.exception;

public abstract class BaseException extends RuntimeException {
    private final String technicalMessage;
    private final String humanMessage;

    protected BaseException(String technicalMessage, String humanMessage) {
        super(technicalMessage);
        this.technicalMessage = technicalMessage;
        this.humanMessage = humanMessage;
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }

    public String getHumanMessage() {
        return humanMessage;
    }
}
