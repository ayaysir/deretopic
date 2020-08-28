package com.example.deretopic.domain.common;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ThreeSize {
    private int bust, waist, hip;

    @Builder
    public ThreeSize(int bust, int waist, int hip) {
        this.bust = bust;
        this.waist = waist;
        this.hip = hip;
    }
}
