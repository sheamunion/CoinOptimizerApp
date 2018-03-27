package com.sheamunion.CoinOptimizer;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CoinOptimizerTest {

    private CoinOptimizer optimizer;

    private Map<String, Integer> generateExpectedCaseOutput(Integer[] coins) {
        Map<String, Integer> expectedOutput = new HashMap<>();

        expectedOutput.put("silver-dollar", coins[0]);
        expectedOutput.put("half-dollar", coins[1]);
        expectedOutput.put("quarter", coins[2]);
        expectedOutput.put("dime", coins[3]);
        expectedOutput.put("nickel", coins[4]);
        expectedOutput.put("penny", coins[5]);

        return expectedOutput;
    }

    @Before
    public void setUp() throws Exception {
        optimizer = new CoinOptimizer();
    }

    @Test
    public void optimizingWithValidInputReturnsCorrectHash() throws Exception {
        Map<String, Integer> expectedCaseOneOutput = generateExpectedCaseOutput(new Integer[] {0,1,1,2,0,4});
        Map<String, Integer> expectedCaseTwoOutput = generateExpectedCaseOutput(new Integer[] {1,1,0,0,1,1});
        Map<String, Integer> expectedCaseThreeOutput = generateExpectedCaseOutput(new Integer[] {12,1,1,1,0,0});

        Map<String, Integer> caseOneOutput = optimizer.optimize(99.0);
        Map<String, Integer> caseTwoOutput = optimizer.optimize(156.0);
        Map<String, Integer> caseThreeOutput = optimizer.optimize(1285.0);

        assertEquals(expectedCaseOneOutput, caseOneOutput);
        assertEquals(expectedCaseTwoOutput, caseTwoOutput);
        assertEquals(expectedCaseThreeOutput, caseThreeOutput);
    }

    @Test
    public void returnsCorrectCoinCountAndRemainder() throws Exception {
        Integer expectedCoins = 2;
        Double expectedRemainder = 0.0;

        CoinOptimizer.CustomTuple result = optimizer.getCoinsAndRemainder(200.0, 100);
        Integer coins = result.getCoins();
        Double remainder = result.getRemainder();

        assertEquals("Coins", expectedCoins, coins);
        assertEquals("Remainder", expectedRemainder, remainder);
    }

    @Test
    public void whenDollarValueIsNotAWholeNumber() throws Exception {
        Integer expectedCoins = 5;
        Double expectedRemainder = 49.0;

        CoinOptimizer.CustomTuple result = optimizer.getCoinsAndRemainder(299.0, 50);
        Integer coins = result.getCoins();
        Double remainder = result.getRemainder();

        assertEquals("Coins", expectedCoins, coins);
        assertEquals("Remainder", expectedRemainder, remainder);
    }
}