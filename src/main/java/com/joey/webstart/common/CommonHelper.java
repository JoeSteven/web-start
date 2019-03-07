package com.joey.webstart.common;

import org.springframework.web.servlet.ModelAndView;

public class CommonHelper {
    public static ModelAndView generate(Object object) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view");
        modelAndView.getModel().put("data", object);
        return modelAndView;
    }
}
