package com.joey.webstart.common;

public class CommonEmptyResponse {
    public int code = 0;
    public String message = "success";
    public CommonEmptyResponse() {

    }

    public CommonEmptyResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
