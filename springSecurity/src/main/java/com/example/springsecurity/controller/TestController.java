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

    @RequestMapping("/admin/2")
    public String adminPage() {
          return "admin/2";
    }

    @RequestMapping("/role1/1")
    public String role1Page(){
         return "role1/1";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("/")
    public String test1(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        System.out.println("logging...success");
        return "index";
    }

    @RequestMapping("/Err")
    public String err(){
        System.out.println("logging...err");
        return "Err";
    }
}
