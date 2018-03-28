package com.sheamunion.CoinOptimizer;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CoinOptimizerTest {

    private CoinOptimizer optimizer;

    private Map<String, Integer> generateExpectedCaseOutput(Integer[] coins) {
        Map<String, Integer> expectedOutput = new LinkedHashMap<>();

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

        assertEquals("Case one", expectedCaseOneOutput, caseOneOutput);
        assertEquals("Case two", expectedCaseTwoOutput, caseTwoOutput);
        assertEquals("Case three", expectedCaseThreeOutput, caseThreeOutput);
    }

    @Test
    public void optimizedResultShouldBeOrderedByDescendingCoinValue() {
        Map<String, Integer> caseOneOutput = optimizer.optimize(99.0);

        assertThat(String.join(",", caseOneOutput.keySet()),  CoreMatchers.containsString("silver-dollar,half-dollar,quarter,dime,nickel,penny"));
        assertThat(String.join(",", caseOneOutput.keySet()),  CoreMatchers.not(CoreMatchers.containsString("half-dollar,quarter,dime,nickel,penny,silver-dollar")));
    }

    @Test
    public void returnsCorrectCoinCount() throws Exception {
        Integer expectedCoins = 2;

        Integer resultCoins = optimizer.getCoins(200.0, 100);

        assertEquals("Coins", expectedCoins, resultCoins);
    }

    @Test
    public void returnsCorrectRemainder() throws Exception {
        Double expectedRemainder = 4.0;

        Double remainder = optimizer.getRemainder(79.0, 75);

        assertEquals("Remainder", expectedRemainder, remainder);
    }
}