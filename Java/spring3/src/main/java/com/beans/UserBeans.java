package com.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserBeans {
    @Bean(name = "userInfo")
    public User user1() {
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        return user;
    }

    @Bean
    public User user2() {
        User user = new User();
        user.setId(1);
        user.setName("lisi");
        return user;
    }
}
