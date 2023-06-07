package com.iot.petplate.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String exceptionName;
    private String technicalMessage;
    private String humanMessage;
}