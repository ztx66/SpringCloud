package com.example.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * config中配置用户名和密码
 * @author zhantianxin
 * @version 1.0
 * @date 2022/10/11 9:51
 */
@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        //用户名密码设置  可以把这里改成通过数据库查询
        // 这里使用的在内存中定义
        /*auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("admin123")).roles("admin");*/

        //这里使用自定义类的方式
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

           //自定义页面
           http.formLogin()
                   .loginPage("/login.html")
                   .loginProcessingUrl("/login")
                   //配置接收的用户名密码参数
                   .usernameParameter("username")
                   .passwordParameter("password")
                   //登陆成功后调转的请求
                   .defaultSuccessUrl("/index").failureUrl("/Err").permitAll();

            //关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求
            http.csrf().disable();

            http.authorizeRequests()
                    //premitAll()的意思就是放行，这里除了登录页放行，其他的都需要认证
                    .antMatchers("/","/login").permitAll()
                    //赋权，指定目录下的页面需要特定角色 这里我把admin权限设置的比较高，也能访问role1的页面
                    .antMatchers("/admin/2").hasAnyAuthority("admin")
                    .antMatchers("/role1/1").hasAnyAuthority("admin,role1");
    }




}
