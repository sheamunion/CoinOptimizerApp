package com.sheamunion.CoinOptimizer;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

public class CoinOptimizer {

    private static final Map<String, BigDecimal> COIN_VALUES = new LinkedHashMap<>();

    public CoinOptimizer() {
        COIN_VALUES.put("silver-dollar", new BigDecimal("100"));
        COIN_VALUES.put("half-dollar", new BigDecimal("50"));
        COIN_VALUES.put("quarter", new BigDecimal("25"));
        COIN_VALUES.put("dime", new BigDecimal("10"));
        COIN_VALUES.put("nickel", new BigDecimal("5"));
        COIN_VALUES.put("penny", new BigDecimal("1"));
    }

    public Map<String, BigDecimal> optimize(BigDecimal value) {
        Map<String, BigDecimal> result = new LinkedHashMap<>();

        BigDecimal coins = getCoins(value, COIN_VALUES.get("silver-dollar"));
        BigDecimal remainder = getRemainder(value, COIN_VALUES.get("silver-dollar"));
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

    public BigDecimal getCoins(BigDecimal value, BigDecimal coin) {
        return value.divide(coin).setScale(0, RoundingMode.FLOOR);
    }

    public BigDecimal getRemainder(BigDecimal value, BigDecimal coin) {
        return value.remainder(coin);
    }
}
