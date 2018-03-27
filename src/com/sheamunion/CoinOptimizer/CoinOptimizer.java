package com.sheamunion.CoinOptimizer;

import java.util.HashMap;
import java.util.Map;

public class CoinOptimizer {

    public CoinOptimizer() {}

    public Map<String, Integer> optimize(Double value) {
        Map<String, Integer> result = new HashMap<String, Integer>();

        Double[] silverDollarsAndRemainder = getSilverDollarsAndRemainder(value);
        Double silverDollars = silverDollarsAndRemainder[0], remainder = silverDollarsAndRemainder[1];
        result.put("silver-dollar", silverDollars.intValue());

        return result;
    }

    public Double[] getSilverDollarsAndRemainder(Double value) {
        Double quotient = value / 100;
        Double remainder = value % 100;

        return new Double[]{quotient, remainder};
    }
}
