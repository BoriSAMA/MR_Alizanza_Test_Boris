package com.alianza.clientes.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public class BaseResponse {

    private boolean success;
    private int statusCode;
    private String message;

    public BaseResponse() {
        super();
    }

    public BaseResponse(boolean success, @NotNull HttpStatus status, String message) {
        this.success = success;
        this.statusCode = status.value();
        this.message = message;
    }

    public BaseResponse(boolean success, int statusCode, String message) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @JsonIgnore
    public HttpStatus getStatus() {
        for (HttpStatus status : HttpStatus.values()) {
            if (status.value() == statusCode) {
                return status;
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    @JsonIgnore
    public void setStatus(HttpStatus status) {
        this.statusCode = status.value();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
