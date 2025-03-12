package com.example.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

//@JsonTypeName("logStashData") // 可选，用于明确类型名称
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public class LogStashData<T extends Enum<T>, R> extends CommonEntity<T, R>{

    private String otherInfo;

    public LogStashData(){}

    public LogStashData(R key, MetricBucket<T> metricBucket) {
        super(key, metricBucket);
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}
