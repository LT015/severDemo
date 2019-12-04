package com.example.lt.demo.controller;


import com.example.lt.demo.model.dto.UserDto;
import com.example.lt.demo.service.LoginService;
import com.example.lt.demo.util.PubUtil;
import com.example.lt.demo.util.ResponseCode;
import com.example.lt.demo.util.ResponseData;
import com.example.lt.demo.util.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.ResponseMessage;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    LoginService loginService;

    @PostMapping("/pwd")
    @ResponseBody
    public ResponseData login(HttpServletResponse response,@RequestParam("userId") String userId, @RequestParam("password") String password) {
        if (loginService.checkUser(userId, password)) {
            String sessionId = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("TJUFE-SESSION-ID", sessionId);
            cookie.setMaxAge(7 * 24 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
            stringRedisTemplate.opsForValue().set(sessionId, userId, 7, TimeUnit.DAYS);
            UserDto userDto = new UserDto("1001","张三");
            return ResponseData.success(userDto);
        }

        return ResponseData.fail(ResponseCode.FAIL, ResponseMsg.LOGIN_FAIL);
    }

    /**
     * 确认是否登录
     *
     * @param request  用于获取cookie
     * @param response 用于写回信息
     * @return 用户是否处于登录状态
     */
    @GetMapping("/checkLogin")
    public ResponseData checkLogin(HttpServletRequest request, HttpServletResponse response) {
        String sessionId = PubUtil.getSessionId(request);
        String stuId = stringRedisTemplate.opsForValue().get(sessionId);
        if (StringUtils.isEmpty(stuId)) {
            //PubUtil.responseUnAuthorizedError(response);
            return null;
        }
        return ResponseData.success(ResponseMsg.LOGIN);
    }
}
