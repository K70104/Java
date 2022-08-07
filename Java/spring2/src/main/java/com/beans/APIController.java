package com.beans;


import org.springframework.stereotype.Component;

@Component
public class APIController {
    public void sayHi() {
        System.out.println("hello, UserComponent");
    }
}
