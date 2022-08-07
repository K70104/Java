package com.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserBeans {
    @Bean(name = {"userInfo", "userTest"}) // 注意：只使用一个 @Bean 是无法将对象存储到容器中的
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
