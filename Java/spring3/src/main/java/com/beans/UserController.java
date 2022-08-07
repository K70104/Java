package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 根据属性实现 bean 对象的注入
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void sayHi() {
        userService.sayHi();
    }
}

//@Controller
//public class UserController {
////    @Resource(name = "user2")
//    @Autowired
//    @Qualifier(value = "user2")
////    @Qualifier("user2")
//    public User user;
//
//    public void sayHi() {
//        System.out.println("User —— " + user);
//    }
//}
