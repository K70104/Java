package com.example.springboot_logger.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j // 替代了 LoggerFactory.getLogger 操作
public class UserService {

    @RequestMapping("/sayhi2")
    public void sayHi() {
        log.trace("I'm trace");
        log.debug("I'm debug");
        log.info("I'm info");
        log.warn("I'm warn");
        log.error("I'm error");
    }
}
