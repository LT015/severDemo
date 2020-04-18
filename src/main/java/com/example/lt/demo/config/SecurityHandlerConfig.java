//package com.example.lt.demo.config;
//
//
//import com.example.lt.demo.util.ResponseData;
//import com.example.lt.demo.util.ResponseMsg;
//import com.example.lt.demo.util.ResponseUtil;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//import springfox.documentation.service.ResponseMessage;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Configuration
//public class SecurityHandlerConfig {
//
//    /**
//     * 登陆成功，返回Token
//     *
//     * @return
//     */
//    @Bean
//    public AuthenticationSuccessHandler loginSuccessHandler() {
//        return new AuthenticationSuccessHandler() {
//
//            @Override
//            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                                Authentication authentication) throws IOException, ServletException {
//                LoginUser loginUser = (LoginUser) authentication.getPrincipal();
//                Token token = tokenService.saveToken(loginUser);
//
////				try {
////					HttpUtil.doPost("http://localhost:8081/", loginUser.getUsername());
////				} catch (Exception e) {
////					e.printStackTrace();
////				}
//                if ("2".equals(loginUser.getUserType()) || "9".equals(loginUser.getUserType())) {
//                    System.out.println("登录初始化开始");
//                    doInitializeGet(loginUser);
//                    System.out.println("登录初始化结束");
//                }
//                ResponseUtil.responseJson(response, HttpStatus.OK.value(), token);
//            }
//
//            @Async
//            private void doInitializeGet(LoginUser loginUser) {
//                System.out.println("异步开始");
//                System.out.println(loginUser);
//                HttpUtil.doGet("http://localhost:8082/initialize/lsyy?username=" + loginUser.getUsername()
//                        + "&orgId=" + loginUser.getOrgId() + "&orgName=" + loginUser.getOrgName());
//                System.out.println("异步结束");
//            }
//        };
//    }
//
//    /**
//     * 登陆失败
//     *
//     * @return
//     */
//    @Bean
//    public AuthenticationFailureHandler loginFailureHandler() {
//        AuthenticationFailureHandler failureHandler = new AuthenticationFailureHandler() {
//
//            @Override
//            public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//                                                AuthenticationException exception) throws IOException, ServletException {
//                String msg = null;
//                if (exception instanceof BadCredentialsException) {
//                    msg = "密码错误";
//                } else {
//                    msg = exception.getMessage();
//                }
//                ResponseData info = ResponseData.fail(HttpStatus.UNAUTHORIZED.value(), msg);
//                ResponseUtil.responseJson(response, HttpStatus.UNAUTHORIZED.value(), info);
//            }
//        };
//        return failureHandler;
//
//    }
//
//    /**
//     * 未登录，返回401
//     *
//     * @return
//     */
//    @Bean
//    public AuthenticationEntryPoint authenticationEntryPoint() {
//        return new AuthenticationEntryPoint() {
//            @Override
//            public void commence(HttpServletRequest request, HttpServletResponse response,
//                                 AuthenticationException authException) throws IOException, ServletException {
//                ResponseData info = ResponseData.fail(HttpStatus.UNAUTHORIZED.value(), ResponseMsg.NO_LOGIN);
//                ResponseUtil.responseJson(response, HttpStatus.UNAUTHORIZED.value(), info);
//            }
//        };
//    }
//
//    /**
//     * 退出处理
//     *
//     * @return
//     */
//    @Bean
//    public LogoutSuccessHandler logoutSussHandler() {
//        return new LogoutSuccessHandler() {
//
//            @Override
//            public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException, ServletException {
//                ResponseInfo info = new ResponseInfo(HttpStatus.OK.value() + "", "退出成功");
//
//                String token = TokenFilter.getToken(request);
//                tokenService.deleteToken(token);
//
//                ResponseUtil.responseJson(response, HttpStatus.OK.value(), info);
//            }
//        };
//
//    }
//
//    /**
//     *  无权访问
//     *
//     * @return
//     */
//    @Bean
//    public AccessDeniedHandler accessDeniedHandler(){
//        return new AccessDeniedHandler() {
//            @Override
//            public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//                               AccessDeniedException e) throws IOException, ServletException {
//                ResponseData info = ResponseData.fail(HttpStatus.UNAUTHORIZED.value(), ResponseMsg.NO_LOGIN);
//                ResponseUtil.responseJson(httpServletResponse, HttpStatus.UNAUTHORIZED.value(), info);
//            }
//        };
//    }
//}
