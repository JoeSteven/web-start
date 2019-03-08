package com.joey.webstart.interceptor;

import com.joey.webstart.common.CommonEmptyResponse;
import com.joey.webstart.common.CommonHelper;
import com.joey.webstart.common.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResponseAdviceImpl implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof CommonEmptyResponse || o instanceof CommonResponse) {
            return o;
        }
        if (o instanceof Exception) {
            return new CommonEmptyResponse(-10000, o.toString());
        }
        if (o != null) {
            return new CommonResponse(o);
        }
        return new CommonEmptyResponse();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object errorResponse(HttpServletRequest req, Exception e) throws Exception{
        if (e instanceof ApiException) {
            return new CommonEmptyResponse(((ApiException)e).code, ((ApiException)e).message);
        }
        return e;
    }
}
