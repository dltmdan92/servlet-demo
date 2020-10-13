package com.seungmoo.springmvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 때는 클래스가 handler가 된다. (BeanName 핸들러)
@org.springframework.stereotype.Controller("/simple")
public class SimpleController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return new ModelAndView("simple");
    }
}
