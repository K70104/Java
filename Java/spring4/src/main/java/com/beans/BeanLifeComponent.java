package com.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class BeanLifeComponent implements BeanNameAware {
    @PostConstruct
    public void postConstruct() {
        System.out.println("执⾏ @PostConstruct()");
    }

    public void init() {
        System.out.println("执⾏ init-method");
    }

    public void use() {
        System.out.println("使用 bean");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("执⾏ @PreDestroy");
    }

    public void setBeanName(String s) {
        System.out.println("执⾏了 Aware 通知");
    }
}