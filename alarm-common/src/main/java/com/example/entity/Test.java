package com.example.entity;

import com.example.collect.MetricCollect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // 忽略 null 值

    }

    public static void main(String[] args) throws JsonProcessingException {
        Key1 key1 = new Key1();
        Key2 key2 = new Key2();
        MetricCollect.add(MetricEvent.PASS, key1);
        MetricCollect.add(MetricEvent.PASS, key2);


        List<LogStashData> logStashDataList = MetricCollect.format();

        List<String> jsonList = new ArrayList<>();

        // 序列化
        for (LogStashData<?, ?> logStashData : logStashDataList) {
            String json = mapper.writeValueAsString(logStashData);
            jsonList.add(json);
            System.out.println("Serialized JSON: " + json);
        }

        // 反序列化
        for (String json : jsonList) {
            LogStashData<?, ?> deserialized = mapper.readValue(
                    json,
                    new TypeReference<LogStashData<?, ?>>() {} // 明确指定目标类型
            );
            System.out.println("Deserialized Key: " + deserialized.getKey());
            System.out.println("Metrics: " + deserialized.getMetricBucket().getMetrics());
//            System.out.println("Other Info: " + deserialized.getOtherInfo());
        }
    }
}