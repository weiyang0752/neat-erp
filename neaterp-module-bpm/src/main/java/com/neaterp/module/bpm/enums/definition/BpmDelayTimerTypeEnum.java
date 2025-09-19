package com.neaterp.module.bpm.enums.definition;

import com.neaterp.framework.common.core.ArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * BPM 延迟器类型枚举
 *
 * @author Lesan
 */
@Getter
@AllArgsConstructor
public enum BpmDelayTimerTypeEnum implements ArrayValuable<Integer> {

    FIXED_TIME_DURATION(1, "固定时长"),
    FIXED_DATE_TIME(2, "固定日期");

    private final Integer type;
    private final String name;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(BpmDelayTimerTypeEnum::getType).toArray(Integer[]::new);

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

}