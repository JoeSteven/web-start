package com.joey.webstart.common;

public class CommonResponse<T> {
    public int code = 0;
    public String message = "success";
    public T data;
    public CommonResponse(T data) {
        this.data = data;
    }
}
