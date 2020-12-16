package com.codecool.itemhandlerservice.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Rarity {
    COMMON("statMultiplier","1","sellPrice","1","buyPrice","2","motivation","0"),
    UNCOMMON("statMultiplier","2","sellPrice","2","buyPrice","4","motivation","0"),
    RARE("statMultiplier","3","sellPrice","3","buyPrice","9","motivation","2"),
    EPIC("statMultiplier","4","sellPrice","4","buyPrice","16","motivation","4");



    private final Map<String, Long> map;

    Rarity(String... keysAndValues) {
        if (keysAndValues.length % 2 != 0){
            throw new IllegalArgumentException("keysAndValues has odd size");
        }
        this.map = new HashMap<>();
        for (int i = 0; i < keysAndValues.length; i += 2) {
            if (keysAndValues[i] == null || keysAndValues[i + 1] == null)
                throw new NullPointerException();
            if (this.map.put(keysAndValues[i], Long.valueOf(keysAndValues[i + 1])) != null)
                throw new IllegalArgumentException("keysAndValues has duplicate key named '" + keysAndValues[i] + "': " + Arrays.toString(keysAndValues));
        }
    }

    public Map<String, Long> getMap() {
        return this.map;
    }
}
