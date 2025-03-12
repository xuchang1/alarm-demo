package com.example.collect;

import com.example.entity.CommonEntity;
import com.example.entity.LogStashData;
import com.example.entity.MetricBucket;
import com.example.entity.MetricEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetricCollect {

    private static volatile Map<Object, MetricBucket> map = new HashMap<>();

    public static <T extends Enum<T>, R> void add(T t, R key) {
        MetricBucket<T> metricBucket = getMetricBucket(key, t);
        metricBucket.add(t);
    }

    public static List<LogStashData> format() {
        List<LogStashData> result = new ArrayList<>();
        map.forEach((key, value) -> result.add(new LogStashData(key, value)));
        return result;
    }

    private static <T extends Enum<T>, R> MetricBucket<T> getMetricBucket(R key, T t) {
        MetricBucket<T> metricBucket = map.get(key);
        if (null == metricBucket) {
            synchronized (MetricEvent.class) {
                metricBucket = map.get(key);
                if (null == metricBucket) {
                    metricBucket= new MetricBucket(t.getClass());
                    HashMap<Object, MetricBucket> newMap = new HashMap<>(map);
                    newMap.put(key, metricBucket);
                    map = newMap;
                }

            }
        }

        return metricBucket;
    }
}
