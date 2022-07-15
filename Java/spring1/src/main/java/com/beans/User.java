package com.beans;

/**
 * 普通的 bean 对象
 */
public class User {
    public User() {
        System.out.println("加载了 User");
    }

    public void sayHi(String name) {
        System.out.println("hello: " + name + "!");

    }
}
