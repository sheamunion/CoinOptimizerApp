package com.sheamunion.CoinOptimizer;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CoinOptimizerTest {

    private CoinOptimizer optimizer;

    private Map<String, BigDecimal> generateExpectedCaseOutput(String[] coins) {
        Map<String, BigDecimal> expectedOutput = new LinkedHashMap<>();

        expectedOutput.put("silver-dollar", new BigDecimal(coins[0]));
        expectedOutput.put("half-dollar", new BigDecimal(coins[1]));
        expectedOutput.put("quarter", new BigDecimal(coins[2]));
        expectedOutput.put("dime", new BigDecimal(coins[3]));
        expectedOutput.put("nickel", new BigDecimal(coins[4]));
        expectedOutput.put("penny", new BigDecimal(coins[5]));

        return expectedOutput;
    }

    @Before
    public void setUp() throws Exception {
        optimizer = new CoinOptimizer();
    }

    @Test
    public void optimizingWithValidInputReturnsCorrectHash() throws Exception {
        Map<String, BigDecimal> expectedCaseOneOutput = generateExpectedCaseOutput(new String[] {"0","1","1","2","0","4"});
        Map<String, BigDecimal> expectedCaseTwoOutput = generateExpectedCaseOutput(new String[] {"1","1","0","0","1","1"});
        Map<String, BigDecimal> expectedCaseThreeOutput = generateExpectedCaseOutput(new String[] {"12","1","1","1","0","0"});

        Map<String, BigDecimal> caseOneOutput = optimizer.optimize(new BigDecimal("99.0"));
        Map<String, BigDecimal> caseTwoOutput = optimizer.optimize(new BigDecimal("156.0"));
        Map<String, BigDecimal> caseThreeOutput = optimizer.optimize(new BigDecimal("1285.0"));

        assertEquals("Case one", expectedCaseOneOutput, caseOneOutput);
        assertEquals("Case two", expectedCaseTwoOutput, caseTwoOutput);
        assertEquals("Case three", expectedCaseThreeOutput, caseThreeOutput);
    }

    @Test
    public void optimizesVeryLargeNumbersCorrectly() throws Exception {
        Map<String, BigDecimal> expectedCaseOneOutput = generateExpectedCaseOutput(new String[] {"999999999999","0","0","1","1","0"});

        Map<String, BigDecimal> caseOneOutput = optimizer.optimize(new BigDecimal("99999999999915"));

        assertEquals("Case one", expectedCaseOneOutput, caseOneOutput);
    }

    @Test
    public void optimizedResultShouldBeOrderedByDescendingCoinValue() {
        Map<String, BigDecimal> caseOneOutput = optimizer.optimize(new BigDecimal(99.0));

        assertThat(String.join(",", caseOneOutput.keySet()),  CoreMatchers.containsString("silver-dollar,half-dollar,quarter,dime,nickel,penny"));
        assertThat(String.join(",", caseOneOutput.keySet()),  CoreMatchers.not(CoreMatchers.containsString("half-dollar,quarter,dime,nickel,penny,silver-dollar")));
    }

    @Test
    public void returnsCorrectCoinCount() throws Exception {
        BigDecimal expectedCoins = BigDecimal.valueOf(2);

        BigDecimal resultCoins = optimizer.getCoins(new BigDecimal(200.0), new BigDecimal(100));

        assertEquals("Coins", expectedCoins, resultCoins);
    }

    @Test
    public void returnsCorrectRemainder() throws Exception {
        BigDecimal expectedRemainder = new BigDecimal(4);

        BigDecimal remainder = optimizer.getRemainder(new BigDecimal(79.0), new BigDecimal(25));

        assertEquals("Remainder", expectedRemainder, remainder);
    }
}