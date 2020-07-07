package com.cjw.auth.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname AuthClient
 * @Description
 * @Date 2020/7/7 22:09
 * @Created by cjw
 */
@RequestMapping("auth")
public interface AuthApi {
    @GetMapping("login")
    @ResponseBody
    public String login();
}
