package com.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class UserBeans {
    @Bean(name = "user1")
    public User getUser1() {
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        return user;
    }

    @Bean(name = "user2")
    public User getUser2() {
        User user = new User();
        user.setId(2);
        user.setName("lisi");
        return user;
    }

    @Bean(name = "user3")
//    @Scope("prototype")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User getUser3() {
        User user = new User();
        user.setId(3);
        user.setName("Java");
        return user;
    }
}
