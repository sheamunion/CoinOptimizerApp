package com.sheamunion.CoinOptimizer;

import java.util.LinkedHashMap;
import java.util.Map;

public class CoinOptimizer {

    private static final Map<String, Integer> COIN_VALUES = new LinkedHashMap<>();

    public CoinOptimizer() {
        COIN_VALUES.put("silver-dollar", 100);
        COIN_VALUES.put("half-dollar", 50);
        COIN_VALUES.put("quarter", 25);
        COIN_VALUES.put("dime", 10);
        COIN_VALUES.put("nickel", 5);
        COIN_VALUES.put("penny", 1);
    }

    public Map<String, Integer> optimize(Double value) {
        Map<String, Integer> result = new LinkedHashMap<>();

        Integer coins = getCoins(value, COIN_VALUES.get("silver-dollar"));
        Double remainder = getRemainder(value, COIN_VALUES.get("silver-dollar"));
        result.put("silver-dollar", coins);

        for (String key : COIN_VALUES.keySet()) {
            if (key.equals("silver-dollar")) {
                continue;
            }
            coins = getCoins(remainder, COIN_VALUES.get(key));
            remainder = getRemainder(remainder, COIN_VALUES.get(key));
            result.put(key, coins);
        }
        return result;
    }

    public Integer getCoins(Double value, Integer coin) {
        return value.intValue() / coin;
    }

    public Double getRemainder(Double value, Integer coin) {
        return value % coin;
    }
}
