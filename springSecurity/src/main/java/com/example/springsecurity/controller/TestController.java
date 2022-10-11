package com.example.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhantianxin
 * @version 1.0
 * @date 2022/10/11 9:49
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

}
