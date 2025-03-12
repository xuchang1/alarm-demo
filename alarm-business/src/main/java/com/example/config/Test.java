package com.example.config;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        add("1", "3");
        add("1", Arrays.asList("2", "3"));
        add("1",1, "2");
        add("1", 1, Arrays.asList("2", "3"));
    }

    public static <T> void add(T t, Object key) {
        // 处理单个 key 的情况
    }

    public static <T> void add(T t, List<Object> keys) {
        // 处理多个 keys 的情况
    }

    public static <T> void add(T t, long adder, Object key) {
        // 处理 long adder 和单个 key 的情况
    }

    public static <T> void add(T t, long adder, List<Object> keys) {
        // 处理 long adder 和多个 keys 的情况
    }
}