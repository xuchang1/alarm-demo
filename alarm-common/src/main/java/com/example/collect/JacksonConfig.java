package com.example.collect;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonConfig {
    public static ObjectMapper configureObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        // 注册自定义反序列化器
//        SimpleModule module = new SimpleModule();
//        module.addDeserializer(CommonMetric.class, new CommonMetric.CommonMetricDeserializer());
//        mapper.registerModule(module);

        return mapper;
    }
}
