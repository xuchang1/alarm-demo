package com.example.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "a")
//@PropertySource("classpath:application-dev.yml") // 指定其他JAR包中的配置文件路径
@Data
public class AppConfig {

    private String b;
}
