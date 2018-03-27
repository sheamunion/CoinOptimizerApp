package com.sheamunion.CoinOptimizer;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CoinOptimizerTest {

    private CoinOptimizer optimizer;
    public Integer SILVER_DOLLAR = 100;

    @Before
    public void setUp() throws Exception {
        optimizer = new CoinOptimizer();
    }

    @Test
    public void optimizingWithValidInputReturnsCorrectHash() throws Exception {
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
    public void returnsCorrectCoinCountAndRemainder() throws Exception {
        Integer expectedCoins = 2;
        Double expectedRemainder = 0.0;

        CoinOptimizer.CustomTuple result = optimizer.getCoinsAndRemainder(200.0, SILVER_DOLLAR);
        Integer coins = result.getCoins();
        Double remainder = result.getRemainder();

        assertEquals("Coins", expectedCoins, coins);
        assertEquals("Remainder", expectedRemainder, remainder);
    }

    @Test
    public void whenDollarValueIsNotAWholeNumber() throws Exception {
        Integer expectedSilverDollars = 2;
        Double expectedRemainder = 99.0;

        CoinOptimizer.CustomTuple result = optimizer.getCoinsAndRemainder(299.0, SILVER_DOLLAR);
        Integer silverDollars = result.getCoins();
        Double remainder = result.getRemainder();

        assertEquals("Silver dollars", expectedSilverDollars, silverDollars);
        assertEquals("Remainder", expectedRemainder, remainder);
    }
}