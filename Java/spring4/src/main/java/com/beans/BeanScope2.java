package com.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanScope2 {
    @Autowired
    private User user3;

    public User getUser3() {
        return user3;
    }
}
