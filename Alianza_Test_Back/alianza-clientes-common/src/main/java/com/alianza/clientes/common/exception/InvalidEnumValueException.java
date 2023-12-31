package com.alianza.clientes.common.exception;

public class InvalidEnumValueException extends RuntimeException {

    private String field;
    private String value;

    public InvalidEnumValueException(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }
}
