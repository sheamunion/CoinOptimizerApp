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
    public void optimizingWithValidInputReturnsCorrectHash() throws Exception {
        Map<String, Integer> expectedCaseOneOutput = new HashMap<>();
        expectedCaseOneOutput.put("silver-dollar", 0);
        expectedCaseOneOutput.put("half-dollar", 1);
        expectedCaseOneOutput.put("quarter", 1);
        expectedCaseOneOutput.put("dime", 2);
        expectedCaseOneOutput.put("nickel", 0);
        expectedCaseOneOutput.put("penny", 4);

        Map<String, Integer> expectedCaseTwoOutput = new HashMap<>();
        expectedCaseTwoOutput.put("silver-dollar", 1);
        expectedCaseTwoOutput.put("half-dollar", 1);
        expectedCaseTwoOutput.put("quarter", 0);
        expectedCaseTwoOutput.put("dime", 0);
        expectedCaseTwoOutput.put("nickel", 1);
        expectedCaseTwoOutput.put("penny", 1);

        Map<String, Integer> expectedCaseThreeOutput = new HashMap<>();
        expectedCaseThreeOutput.put("silver-dollar", 12);
        expectedCaseThreeOutput.put("half-dollar", 1);
        expectedCaseThreeOutput.put("quarter", 1);
        expectedCaseThreeOutput.put("dime", 1);
        expectedCaseThreeOutput.put("nickel", 0);
        expectedCaseThreeOutput.put("penny", 0);

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