package com.example.springboot_logger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody // 非静态数据
public class UserController {
    // 1、先得到日志对象——来自于slf4j
    private final static Logger log =
            LoggerFactory.getLogger(UserController.class); // 设置当前类的类型

    @RequestMapping("/sayhi")
    public void sayHi() {
        log.trace("I'm trace");
        log.debug("I'm debug");
        log.info("I'm info");
        log.warn("I'm warn");
        log.error("I'm error");
    }
}
