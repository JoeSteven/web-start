package com.joey.webstart.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joey.webstart.common.CommonResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if ("qiaoxiaoxi".equals(token)) {
            return super.preHandle(request, response, handler);
        } else  {
            response.setStatus(200);
            CommonResponse data = new CommonResponse(null);
            data.code = 20003;
            data.message = "unAuthorized!";
            response.getWriter().append(mapper.writeValueAsString(data)).flush();
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            Object o = modelAndView.getModel().get("data");
            CommonResponse data = new CommonResponse(o);
            response.getWriter().append(mapper.writeValueAsString(data)).flush();
        } else {
            super.postHandle(request, response, handler, modelAndView);
        }
    }
}
