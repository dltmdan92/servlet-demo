package com.seungmoo.springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// 해당 프로젝트는 스프링부트가 아닌 쌩 스프링 MVC로 MVC 프로젝트 구축하는 것임
@Configuration
// 애노테이션 기반 MVC를 사용할 때 @EnableWebMvc를 사용하면 좋다
// 애노테이션 기반 MVC를 위한 기본 설정 제공
// HandlerMapping, HandlerAdapter에서 RequestMappingHandlerMapping, Adapter가 제일 우선순위 --> 성능 좋아짐
// 클래스 패스에 뭐가 있냐에 따라 메시지컨버터(req, res 처리)를 등록해준다.(jackson, jaxb 등등)
// @Configuration에 DispatcherServlet의 구성요소들을 일일이 Bean으로 등록하는 방법은 구식임 --> @EnableWebMvc통해 애노테이션 기반 설정 해주도록 하면 좋다.
@EnableWebMvc // @EnableWebMvc 를 사용하는 순간 스프링부트가 제공하는 mvc configuration을 쓰지 않는 것임 (springboot가 아닌 쌩 spring-mvc에서는 무조건 쓰는 듯)
// @EnableWebMvc + WebMvcConfigurer ==> spring web mvc 셋팅 + WebMvcConfigurer를 통한 추가 커스터마이징
@ComponentScan(useDefaultFilters = false, includeFilters = @ComponentScan.Filter(Controller.class))
public class WebConfig implements WebMvcConfigurer {

    // DispatcherServlet에서 이미 SPRING MVC 구성요소로 등록되는 Bean이지만
    // Config에서 직접 Bean으로 등록할 수도 있다. (handlerMapping, handlerAdapter, resolver 등등)
    // DispatcherServlet에서 적용하는 기본 전략만이 아니라 추가적으로 셋팅필요할 경우 직접 Bean등록 한다.
    // low-level 방식으로 설정하는 것임 (이 방식은 많이 쓰지 않음)
    /*
    @Bean
    public HandlerMapping handlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
        // 핸들러 인터셉터, bean으로도 등록 가능 (필터처럼 각 handlerMapping들에 대해 설정이 가능하다)
        handlerMapping.setInterceptors();
        handlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return handlerMapping;
    }

    @Bean
    public HandlerAdapter handlerAdapter() {
        RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
        return handlerAdapter;
    }

     */

    /*
    // viewResolver를 직접 Bean으로 등록하지 않아도
    // WebMvcConfigurer 인터페이스를 통해 @EnableWebMvc가 등록해주는 viewResolver를 별도로 커스터마이징할 수 있다.
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
     */

    // viewResolver를 직접 Bean으로 등록하지 않아도
    // WebMvcConfigurer 인터페이스를 통해 @EnableWebMvc가 등록해주는 viewResolver를 별도로 커스터마이징할 수 있다.
    // @EnableWebMvc가 제공하는 ViewResolver 하나로 통일할 수 있다.
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/", ".jsp");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // formatter 등록 필요
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 인터셉터 등록 필요
    }


}
