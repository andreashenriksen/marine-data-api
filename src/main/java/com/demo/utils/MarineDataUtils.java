package com.demo.utils;

import com.demo.model.MarineData;

import java.util.List;

public class MarineDataUtils {

    public static Long getMaxId(List<MarineData> marineDataList) {
        Long maxId = Long.MIN_VALUE;

        for (MarineData marineData : marineDataList) {
            Long currentId = marineData.getId();
            if (currentId != null && currentId > maxId) {
                maxId = currentId;
            }
        }

        return maxId;
    }

    public static Long getNextId(List<MarineData> marineDataList) {
        Long maxId = getMaxId(marineDataList);
        return ++maxId;
    }
}
