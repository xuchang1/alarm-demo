package com.example.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = LogStashData.class, name = "logStashData") // 声明子类
//})
public class CommonEntity<T extends Enum<T>, R> {

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
    private R key;

    private MetricBucket<T> metricBucket;

    public CommonEntity() {
    }

    public CommonEntity(R key, MetricBucket<T> metricBucket) {
        this.key = key;
        this.metricBucket = metricBucket;
    }

    public R getKey() {
        return key;
    }

    public void setKey(R key) {
        this.key = key;
    }

    public MetricBucket<T> getMetricBucket() {
        return metricBucket;
    }

    public void setMetricBucket(MetricBucket<T> metricBucket) {
        this.metricBucket = metricBucket;
    }
}
