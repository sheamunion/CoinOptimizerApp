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

    public CoinOptimizer() {}

    public Map<String, Integer> optimize(Double value) {
        Map<String, Integer> result = new HashMap<String, Integer>();

        CustomTuple silverDollarsAndRemainder = getSilverDollarsAndRemainder(value);
        Integer silverDollars = silverDollarsAndRemainder.getCoins();
        Double remainder = silverDollarsAndRemainder.getRemainder();
        result.put("silver-dollar", silverDollars);

        Double[] halfDollarsAndRemainder = getHalfDollarsAndRemainder(remainder);
        Double halfDollars = halfDollarsAndRemainder[0];
        remainder = halfDollarsAndRemainder[1];
        result.put("half-dollar", halfDollars.intValue());

        return result;
    }

    public CustomTuple getSilverDollarsAndRemainder(Double value) {
        Integer quotient = value.intValue() / 100;
        Double remainder = value % 100;

        return new CustomTuple(quotient, remainder);
    }

    public Double[] getHalfDollarsAndRemainder(Double value) {
        Double quotient = value / 50;
        Double remainder = value % 50;

        return new Double[]{quotient, remainder};
    }
}
