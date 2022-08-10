package com.example.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

//    @Value("${myyml.string}") // 读取配置项
//    private String ymlstr;
//
//    @Value("${server.port}")
//    private String port;
//
//
//    @Value("${mystring1}")
//    private String mystring1;
//
//    @Value("${mystring2}")
//    private String mystring2;
//
//    @Value("${mystring3}")
//    private String mystring3;




//    @Autowired
//    private Student student; // 属性注入



    @Resource
    private ReadList readList;

    @ResponseBody
    @RequestMapping("/sayhi")
    public String sayhi() {
        return "readList: " + readList.getName();



//        return "student: " + student;


//        System.out.println("mystring1: " + mystring1);
//        System.out.println("mystring2: " + mystring2);
//        System.out.println("mystring3: " + mystring3);
//
//
//        System.out.println("ymlstr: " + ymlstr);
//        System.out.println("port: " + port);
//        return "hello, word —— port: " + port;
    }

}
