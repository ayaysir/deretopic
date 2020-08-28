package com.example.deretopic.domain.common;

import java.util.HashMap;
import java.util.Map;

public enum Handedness {
    LEFT("왼손잡이", "", ""),
    RIGHT("오른손잡이", "", ""),
    BOTH("양손잡이", "", ""),
    OTHER("기타", "", "");

    private String[] strings;

    Handedness(String... strings) {
        this.strings = strings;
    }

    public Map<String, String> getHandednessStrings() {
        Map<String, String> result = new HashMap<>();
        result.put("ko", strings[0]);
        result.put("en", strings[1]);
        result.put("ja", strings[2]);

        return result;
    }
}
