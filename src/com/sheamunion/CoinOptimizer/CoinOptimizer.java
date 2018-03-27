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

        Double[] halfDollarsAndRemainder = getHalfDollarsAndRemainder(remainder);
        Double halfDollars = halfDollarsAndRemainder[0];
        remainder = halfDollarsAndRemainder[1];
        result.put("half-dollar", halfDollars.intValue());

        return result;
    }

    public Double[] getSilverDollarsAndRemainder(Double value) {
        Double quotient = value / 100;
        Double remainder = value % 100;

        return new Double[]{quotient, remainder};
    }

    public Double[] getHalfDollarsAndRemainder(Double value) {
        Double quotient = value / 50;
        Double remainder = value % 50;

        return new Double[]{quotient, remainder};
    }
}
