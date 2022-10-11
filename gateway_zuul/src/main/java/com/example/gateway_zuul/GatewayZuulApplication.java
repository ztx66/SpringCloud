package com.example.gateway_zuul;

import com.example.gateway_zuul.filter.MyZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulApplication {

    @Bean
    public MyZuulFilter perRequestLogFilter(){
        return new MyZuulFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulApplication.class, args);
    }

}
