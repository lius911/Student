package com.student.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author li
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("student/home");
        registry.addViewController("/kcb").setViewName("student/kcb");
        registry.addViewController("/updata").setViewName("student/xgmm");
        registry.addViewController("/tealogin").setViewName("teacher/teacherlogin");
        registry.addViewController("/hthome").setViewName("teacher/hthome");
        registry.addViewController("/syxs").setViewName("teacher/xsxx");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Mvcljq()).addPathPatterns("/**").excludePathPatterns("/","/home","/login","/yh","/kcb"
                ,"/updata","/hthome","/tealogin","/syxs","/cxsy",
                "/css/*","/js/*","/img/*");
    }
}
