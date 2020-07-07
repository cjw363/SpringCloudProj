package com.cjw.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname ServicesController
 * @Description
 * @Date 2020/7/7 10:38
 * @Created by cjw
 */
@Controller
@RequestMapping("services")
public class ServicesController {
    @GetMapping(value = "hello")
    @ResponseBody
    public String run(){
        return "hello";
    }
}
