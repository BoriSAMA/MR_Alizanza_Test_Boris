package com.alianza.clientes.common.response;

import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

public abstract class ObjectResponse<T> extends BaseResponse {

    private T data;

    public ObjectResponse() {
        super();
    }

    public ObjectResponse(T data) {
        this(HttpStatus.OK, data);
    }

    public ObjectResponse(String message, T data) {
        super(true, HttpStatus.OK, message);
        this.data = data;
    }

    public ObjectResponse(@NotNull HttpStatus status, T data) {
        super(true, status, status.getReasonPhrase());
        this.data = data;
    }

    public ObjectResponse(HttpStatus status, String message, T data) {
        super(true, status, message);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
