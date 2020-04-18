//package com.example.lt.demo.config;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
////  https://www.jianshu.com/p/2c8750dd20d5
////  https://blog.csdn.net/larger5/article/details/81047869
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    private IdcardSecurityConfig idcardSecurityConfig;  //退出登录
//    @Autowired
//    private AuthenticationSuccessHandler authenticationSuccessHandler;  //登录成功
//    @Autowired
//    private AuthenticationFailureHandler authenticationFailureHandler;  //登录失败
//    @Autowired
//    private LogoutSuccessHandler logoutSuccessHandler;  //退出登录
//    @Autowired
//    private AuthenticationEntryPoint authenticationEntryPoint;  //未登录
//    @Autowired
//    private UserDetailsService userDetailsServiceImpl;  //用户详情
//    @Autowired
//    private AccessDeniedHandler accessDeniedHandler; //无权访问
////    @Autowired
////    private TokenFilter tokenFilter;  //
////    @Autowired
////    private MyValidateCodeFilter myValidateCodeFilter;  //过滤器
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.apply(idcardSecurityConfig);
////        http.csrf().disable()
////                .httpBasic()
////                .authenticationEntryPoint(authenticationEntryPoint);//未登录
////        // 基于token，所以不需要session
////        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
////        http.authorizeRequests()//对请求进行授权
////                .antMatchers("/", "/statics/**")
////                .permitAll()
////                .anyRequest()//任何请求
////                .authenticated();//其他 url 需要身份认证
////        http.formLogin()//开启登录
////                .loginProcessingUrl("/login")
////                .successHandler(authenticationSuccessHandler)// 登录成功
////                .failureHandler(authenticationFailureHandler)// 登录失败
////                .and()
////                .exceptionHandling()
////                .authenticationEntryPoint(authenticationEntryPoint);
////        http.logout().logoutUrl("/logout")
////                .logoutSuccessHandler(logoutSuccessHandler);
////        // 解决不允许显示在iframe的问题
////        http.headers().frameOptions().disable();
////        http.headers().cacheControl();
////
////        myValidateCodeFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
////        http.addFilterBefore(myValidateCodeFilter, UsernamePasswordAuthenticationFilter.class);
////        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder());
//    }
//}
