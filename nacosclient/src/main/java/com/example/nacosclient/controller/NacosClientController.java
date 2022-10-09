package com.example.nacosclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhantianxin
 * @version 1.0
 * @date 2022/10/9 16:43
 */
@RestController
public class NacosClientController {

    @Autowired
   private ProviderFegin providerFegin;

    @GetMapping("/test")
    public String test(){
        return providerFegin.invoke();
    }

    @FeignClient("nacos-provider")
    interface ProviderFegin{

        @GetMapping("invoke")
        String invoke();

    }

}
