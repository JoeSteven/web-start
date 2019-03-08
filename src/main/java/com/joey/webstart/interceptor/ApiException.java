package com.joey.webstart.interceptor;

public class ApiException extends Exception{
    public int code = 0;
    public String message = "success";

    public ApiException(int code,String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
