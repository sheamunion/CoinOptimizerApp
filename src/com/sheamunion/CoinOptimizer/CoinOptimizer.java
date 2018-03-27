package com.sheamunion.CoinOptimizer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CoinOptimizer {

    public class CustomTuple {
        private Integer coins;
        private Double remainder;

        public CustomTuple(Integer coins, Double remainder) {
            this.coins = coins;
            this.remainder = remainder;
        }

        public Integer getCoins() {
            return coins;
        }

        public Double getRemainder() {
            return remainder;
        }
    }

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
        Map<String, Integer> result = new HashMap<>();

        CustomTuple coinsAndRemainder = getCoinsAndRemainder(value, COIN_VALUES.get("silver-dollar"));
        Integer coins = coinsAndRemainder.getCoins();
        Double remainder = coinsAndRemainder.getRemainder();
        result.put("silver-dollar", coins);

        for (String key : COIN_VALUES.keySet()) {
            if (key.equals("silver-dollar")) {
                continue;
            }
            coinsAndRemainder = getCoinsAndRemainder(remainder, COIN_VALUES.get(key));
            coins = coinsAndRemainder.getCoins();
            remainder = coinsAndRemainder.getRemainder();
            result.put(key, coins);
        }
        return result;
    }

    public CustomTuple getCoinsAndRemainder(Double value, Integer coin) {
        Integer quotient = value.intValue() / coin;
        Double remainder = value % coin;

        return new CustomTuple(quotient, remainder);
    }
}
