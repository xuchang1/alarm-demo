package com.example.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

@JsonPropertyOrder({ "enumType", "metrics" })
public class MetricBucket<T extends Enum<T>> {

    private LongAdder[] counters;

    private Class<T> enumType;

    public MetricBucket() {}

    public MetricBucket(Class<T> enumType) {
        this.enumType = enumType;

        T[] events = enumType.getEnumConstants();
        counters = new LongAdder[events.length];
        for (T event : events) {
            counters[event.ordinal()] = new LongAdder();
        }
    }

    public void add(T t) {
        counters[t.ordinal()].add(1L);
    }

    public Map<String, Long> getMetrics() {
        Map<String, Long> map= new HashMap<>();
        T[] events = enumType.getEnumConstants();
        for (T event : events) {
            map.put(event.name(), counters[event.ordinal()].sum());
        }
        return map;
    }

    public void setMetrics(Map<String, Long> data) {
        T[] events = enumType.getEnumConstants();
        counters = new LongAdder[events.length];
        for (T event : events) {
            counters[event.ordinal()] = new LongAdder();
            counters[event.ordinal()].add(data.getOrDefault(event.name(), 0L));
        }
    }

    public String getEnumType() {
        return enumType != null ? enumType.getName() : null;
    }

    public void setEnumType(String enumType) {
        try {
            if (enumType != null) {
                this.enumType = (Class<T>) Class.forName(enumType);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load enum type", e);
        }
    }
}
