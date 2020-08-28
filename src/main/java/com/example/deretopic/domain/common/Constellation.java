package com.example.deretopic.domain.common;

import java.util.HashMap;
import java.util.Map;

public enum Constellation {
    // ko, en, ja
    ARIES("양자리", "", ""),
    TAURUS("황소자리", "", ""),
    GEMINI("쌍둥이자리", "", ""),
    CANCER("게자리", "", ""),
    LEO("사자자리", "", ""),
    VIRGO("처녀자리", "", ""),
    LIBRA("천칭자리", "", ""),
    SCORPIO("전갈자리", "", ""),
    SAGITTARIUS("궁수자리", "", ""),
    CAPRICORN("염소자리", "", ""),
    AQUARIUS("물병자리", "", ""),
    PISCES("물고기자리", "", "");

    private String[] strings;

    Constellation (String... strings) {
        this.strings = strings;
    }

    public Map<String, String> getConstellationStrings() {
        Map<String, String> result = new HashMap<>();
        result.put("ko", strings[0]);
        result.put("en", strings[1]);
        result.put("ja", strings[2]);

        return result;
    }

}
