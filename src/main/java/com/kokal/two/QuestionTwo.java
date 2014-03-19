package com.kokal.two;

import java.util.HashMap;
import java.util.Map;

public class QuestionTwo {

    public static void main(String[] args) {
        int key = 1;
        int len = length(key);
    }

    public static int length(int key) {
        final Map<Long, String> map = new HashMap<Long, String>();
        map.put(Long.valueOf(1), "ONE");

        String one = map.get(key);
        // The following line (one.length()) will throw a NullPointerException because a key matching an
        // Integer with a value 1 was not found (the Map's keys are Longs).
        return one.length();
    }

}
