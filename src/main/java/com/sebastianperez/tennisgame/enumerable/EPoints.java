package com.sebastianperez.tennisgame.enumerable;

import java.util.HashMap;
import java.util.Map;

public class EPoints {
    private static EPoints ourInstance = new EPoints();

    private Map<Integer, String> pointType;

    public static Map<Integer, String> getInstance() {
        return ourInstance.pointType;
    }

    private EPoints() {
        pointType = new HashMap<>();
        pointType.put(0, "LOVE");
        pointType.put(1, "QUINCE");
        pointType.put(2, "TREINTA");
        pointType.put(3, "CUARENTA");
    }
}
