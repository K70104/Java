package com.example.springboot2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties("dbtype") // 读取配置文件中的集合
public class ReadList {
    private List<String> name;
}
