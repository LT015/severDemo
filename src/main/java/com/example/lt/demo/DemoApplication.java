package com.example.lt.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
    在SpringBootApplication上使用@ServletComponentScan注解后，
    Servlet、Filter、Listener可以直接通过
    @WebServlet、@webFilter、@WebListener注解自动注册，无需其他代码。
 */
// http://localhost:8080/swagger-ui.html#/

@SpringBootApplication
//@ServletComponentScan
@EnableRedisHttpSession
class DemoApplication  {//extends SpringBootServletInitializer

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        //将启动类交给Servlet容器进行启动
//        return builder.sources(this.getClass());
//    }

}
