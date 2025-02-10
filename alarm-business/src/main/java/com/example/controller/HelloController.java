package com.example.controller;

import com.example.collect.MetricLogUtil;
import com.example.entity.ThreadPoolMetric;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("test")
    public String test(String id) {
        ThreadPoolMetric threadPoolMetric = new ThreadPoolMetric();
        threadPoolMetric.setActiveCount(100);
        MetricLogUtil.log(threadPoolMetric);
        log.info("id : {}", id);
        return id;
    }
}
