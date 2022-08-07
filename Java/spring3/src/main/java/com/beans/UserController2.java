package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 使用构造方法实现 bean 注入
 */
@Controller
public class UserController2 {
     private UserService userService;

     @Autowired
//    @Resource // err
     public UserController2(UserService userService) {
         this.userService = userService;
     }

     public void sayHi() {
         userService.sayHi();
     }

     // 传统写法
     // public UserController2() {
     //    userService = new UserService();
     //
     //}
}
