package com.example.collect;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetricLogUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger("com.example.collect");

    public static void log(Object o) {
        try {
            logger.info(mapper.writeValueAsString(o));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
