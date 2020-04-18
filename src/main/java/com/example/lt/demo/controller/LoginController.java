package com.example.lt.demo.controller;


import com.example.lt.demo.model.dto.UserDto;
import com.example.lt.demo.service.LoginService;
import com.example.lt.demo.service.UserService;
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
import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @PostMapping("/login/pwd")
    @ResponseBody
    public ResponseData login(HttpServletRequest request,HttpServletResponse response,@RequestParam("userId") String userId, @RequestParam("password") String password) {
        if (loginService.checkUser(userId, password)) {
            /*如果已经存在Session的话，直接返回它；没有就创建一个，再返回
             * 当然Session是自动放在response中的Header中的，这里不用做其他处理*/
            request.getSession().setAttribute("username", "admin");
            return ResponseData.success(  userService.getUserInfo(userId));
        }

        return ResponseData.fail(ResponseCode.FAIL, ResponseMsg.LOGIN_FAIL);
    }

    /**
     * 判断用户的session是否有效（在同一个浏览器中，同一个域中，每次Request请求，都会带上Session）
     * @param request
     * @return
     */
    @RequestMapping(value = "/isValid",method = RequestMethod.GET)
    public String isSessionValid(HttpServletRequest request){
        //判断是不是有效的sessionID
        String userName = (String) request.getSession().getAttribute("username");
        return request.isRequestedSessionIdValid() ? "ok"+userName:"no";
    }

    /**
     * 注销登录
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();//使Session变成无效，及用户退出
        return "logout";
    }
}
