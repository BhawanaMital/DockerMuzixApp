package com.stackroute.Muzixapp;

public class ExceptionResponse {
    private String errorMessage;
    private String requestURL;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL= requestURL;
    }

    public void callerURL(String requestURI) {
        this.requestURL = requestURL;
    }
}