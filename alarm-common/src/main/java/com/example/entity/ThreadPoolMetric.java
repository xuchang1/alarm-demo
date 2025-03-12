package com.example.entity;

public class ThreadPoolMetric extends MetricBucket {

    private int activeCount;

    public int getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(int activeCount) {
        this.activeCount = activeCount;
    }
}
