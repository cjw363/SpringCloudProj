package com.cjw.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname AuthController
 * @Description
 * @Date 2020/7/7 15:25
 * @Created by cjw
 */
@Controller
@RequestMapping("auth")
public class AuthController {
    @PostMapping("login")
    @ResponseBody
    public String login(){
        return "登录成功";
    }
}
