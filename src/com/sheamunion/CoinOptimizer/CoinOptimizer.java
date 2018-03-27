package com.sheamunion.CoinOptimizer;

import java.util.HashMap;
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

    private static final Integer SILVER_DOLLAR = 100;
    private static final Integer HALF_DOLLAR = 50;


    public CoinOptimizer() {}

    public Map<String, Integer> optimize(Double value) {
        Map<String, Integer> result = new HashMap<String, Integer>();

        CustomTuple silverDollarsAndRemainder = getCoinsAndRemainder(value, SILVER_DOLLAR);
        Integer silverDollars = silverDollarsAndRemainder.getCoins();
        Double remainder = silverDollarsAndRemainder.getRemainder();
        result.put("silver-dollar", silverDollars);

        CustomTuple halfDollarsAndRemainder = getCoinsAndRemainder(remainder, HALF_DOLLAR);
        Integer halfDollars = halfDollarsAndRemainder.getCoins();
        remainder = halfDollarsAndRemainder.getRemainder();
        result.put("half-dollar", halfDollars.intValue());

        return result;
    }

    public CustomTuple getCoinsAndRemainder(Double value, Integer coin) {
        Integer quotient = value.intValue() / coin;
        Double remainder = value % coin;

        return new CustomTuple(quotient, remainder);
    }
}
