package com.example.EmployeeApi.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    private static final Long serialVersionUID = 1L;

    private List<FieldMessage> messages = new ArrayList<>();

    public ValidationError(String message, Integer status, Long timestamp) {
        super(message, status, timestamp);
    }

    public List<FieldMessage> getErrors() {
        return messages;
    }

    public void addError(String fieldName, String message) {
        messages.add(new FieldMessage(fieldName, message));
    }
}
