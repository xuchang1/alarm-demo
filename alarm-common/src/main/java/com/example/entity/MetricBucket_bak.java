package com.example.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class MetricBucket_bak<T extends Enum<T>> {

    private LongAdder[] counters;

    private Class<T> enumType;


    public MetricBucket_bak() {}

    public MetricBucket_bak(Class<T> enumType) {
        this.enumType = enumType;

        T[] events = enumType.getEnumConstants();
        counters = new LongAdder[events.length];
        for (T event : events) {
            counters[event.ordinal()] = new LongAdder();
        }
    }

    public long getMetric(T t) {
        return counters[t.ordinal()].sum();
    }

    public Map<String, Long> getMetrics() {
        Map<String, Long> map = new HashMap<>();
        T[] events = enumType.getEnumConstants();
        for (int i = 0; i < counters.length; i++) {
            map.put(events[i].name(), counters[i].sum());
        }
        return map;
    }
}
