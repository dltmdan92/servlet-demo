package com.seungmoo.springmvc;

import com.seungmoo.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;

    // DispatcherServlet에서 핸들러의 역할을 한다.
    // DispatcherServlet에서 HandlerMapping 인터페이스가 각 request에 맞는 handler를 찾아냄
    // 어노테이션 핸들러 매핑은 RequestMappingHandlerMapping 이고 아마 제일 많이 쓸것이다.
    // 그리고 DispatcherServlet에서 HandlerAdapter 인터페이스가 이 handler를 실행시킨다.(자바 리플렉션 사용)
    // HandlerAdapter에서 response에 맞는 ReturnValueHandler를 찾는다.(View, ResponseBody 등등)
    // handler에서 메소드 파라미터 받는 부분에 대해 HandlerAdapter 내 argumentResolver를 통해 셋팅
    /**
     * /hello/1?name=seungmoo&age=25
     * @param id
     * @param user
     * @return
     */
    @GetMapping("/hello/{id}")
    @ResponseBody
    public String hello(@PathVariable int id, @ModelAttribute User user) {
        return "Hello, " + helloService.getName();
    }

    // DispatcherServlet에서 핸들러의 역할을 한다.
    @GetMapping("/sample")
    public String sample() {
        return "sample";
    }
}
