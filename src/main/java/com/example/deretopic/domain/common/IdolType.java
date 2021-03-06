package com.example.deretopic.domain.common;

import java.util.HashMap;
import java.util.Map;

public enum IdolType {
    CUTE("큐트", "", ""),
    COOL("", "쿨", ""),
    PASSION("패션", "", ""),
    OTHER("기타", "", "");

    private String[] strings;

    IdolType(String... strings) {
        this.strings = strings;
    }

    public Map<String, String> getIdolTypeStrings() {
        Map<String, String> result = new HashMap<>();
        result.put("ko", strings[0]);
        result.put("en", strings[1]);
        result.put("ja", strings[2]);

        return result;
    }
}
