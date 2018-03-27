package com.sheamunion.CoinOptimizer;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CoinOptimizerTest {

    private CoinOptimizer optimizer;

    @Before
    public void setUp() throws Exception {
        optimizer = new CoinOptimizer();
    }

    @Test
    public void optimizingWithValidInputRetursCorrectHash() throws Exception {
        Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
        expectedOutput.put("silver-dollar", 0);
        expectedOutput.put("half-dollar", 1);
        expectedOutput.put("quarter", 1);
        expectedOutput.put("dime", 2);
        expectedOutput.put("nickel", 0);
        expectedOutput.put("penny", 4);

        Map<String, Integer> output = optimizer.optimize(99.0);

        assertEquals(expectedOutput, output);
    }

    @Test
    public void getSilverDollarsReturnsCorrectNumberOfSilverDollars() throws Exception {
        Double expectedOutput = 2.0;

        Double[] result = optimizer.getSilverDollarsAndRemainder(200.0);
        Double silverDollars = result[0];

        assertEquals(expectedOutput, silverDollars);
    }

    @Test
    public void getHalfDollarsReturnsCorrectNumberOfHalfDollars() throws Exception {
        Double expectedOutput = 1.0;

        Double[] result = optimizer.getHalfDollarsAndRemainder(50.0);
        Double halfDollars = result[0];

        assertEquals(expectedOutput, halfDollars);
    }
}