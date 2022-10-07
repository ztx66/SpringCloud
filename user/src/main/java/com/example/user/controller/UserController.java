package com.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhantianxin
 * @version 1.0
 * @date 2022/10/7 16:30
 */
@Controller
public class UserController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(){
        return "test111";
    }

}
