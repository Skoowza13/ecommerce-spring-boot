package com.ecom.app.ws.responses;

public enum ErrorMessages {

    MISSING_REQUIRED_FIELD("missing required field"),
    RECORD_ALREADY_EXISTS("recod already exists"),
    INTERNAL_SERVER_ERROR("internal server error"),
    NO_RECORD_FOUND("Record with provided id is not found");

    private String errorMessage;


    private ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}


