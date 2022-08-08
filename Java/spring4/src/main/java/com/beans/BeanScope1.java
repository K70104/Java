package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanScope1 {
    @Autowired // 注入 user3
    private User user3;

    public User getUser3() {
        User user = user3;
        user.setName("八戒");
        return user;
    }
}
