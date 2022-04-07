package com.example.EmployeeApi.controller.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String message;
    private Long timestamp;
    private Integer status;

    public StandardError(String message, Integer status, Long timestamp) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
