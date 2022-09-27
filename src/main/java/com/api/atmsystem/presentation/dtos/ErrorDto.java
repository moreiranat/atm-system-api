package com.api.atmsystem.presentation.dtos;

public class ErrorDto {

    private String field;
    private String error;

    public ErrorDto(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
