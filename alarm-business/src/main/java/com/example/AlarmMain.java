package com.example;

import com.example.collect.MetricLogUtil;
import com.example.entity.CommonMetric;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlarmMain {

    public static void main(String[] args) {
        CommonMetric commonMetric = new CommonMetric();
        SpringApplication.run(AlarmMain.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            ClassLoader classLoader = MetricLogUtil.class.getClassLoader();
//            java.net.URL url = cl.getResource("logback-metric.xml");
            java.net.URL url = cl.getResource("classpath:logback-metric.xml");
            if (url != null) {
                System.out.println("logback-metric.xml found at: " + url.getPath());
            } else {
                System.out.println("logback-metric.xml not found in classpath.");
            }
        };
    }
}
