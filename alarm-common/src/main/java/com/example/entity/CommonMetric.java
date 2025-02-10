package com.example.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

public class CommonMetric<T extends Enum<T>> {

    private LongAdder[] counters;

    private Class<T> enumType;

    private String enumClassName;

    public CommonMetric() {}

    public CommonMetric(Class<T> enumType) {
        this.enumType = enumType;
        this.enumClassName = enumType.getName();

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

    public String getEnumClassName() {
        return enumClassName;
    }

    public void setEnumClassName(String enumClassName) {
        this.enumClassName = enumClassName;
    }
}
