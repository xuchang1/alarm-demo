package com.example.collect;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetricLogUtil {

    private static final Logger logger = LoggerFactory.getLogger("com.example.collect");

    public static void log(Object o) {
        logger.info(JSON.toJSONString(o));
    }
}
