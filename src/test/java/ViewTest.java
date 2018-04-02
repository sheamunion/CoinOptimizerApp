package com.sheamunion.CoinOptimizer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ViewTest {

    private View view;
    private ByteArrayOutputStream myOut;

    @Before
    public void setUp() throws Exception {
        view = new View();
        myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(System.out);
    }

    @Test
    public void displaysHowToUseTheCLI() throws Exception {
        String expectedOutput = "Usage: java -jar com.sheamunion.CoinOptimizer.Main <dollarValue>\n - <dollarValue> formats: 3000.50 or \\$3,000.50 or '$3'\n";

        view.displayUsage();

        assertEquals(expectedOutput, myOut.toString());
    }

    @Test
    public void displaysInvalidInputMessage() throws Exception {
        String expectedOutput = "Please enter a well formatted dollar value.\n - <dollarValue> formats: 3000.50 or \\$3,000.50 or '$3'\n";

        view.displayInvalidInput();

        assertEquals(expectedOutput, myOut.toString());
    }

    @Test
    public void displaysResults() throws Exception {
        String expectedOutput = "Your dollar value has been optimized. \n {nickel=0, dime=2, half-dollar=1, silver-dollar=0, penny=4, quarter=1} \n";
        Map<String, BigDecimal> result = new HashMap<>();
        result.put("silver-dollar", new BigDecimal("0"));
        result.put("half-dollar", new BigDecimal("1"));
        result.put("quarter", new BigDecimal("1"));
        result.put("dime", new BigDecimal("2"));
        result.put("nickel", new BigDecimal("0"));
        result.put("penny", new BigDecimal("4"));

        view.displayResults(result);

        assertEquals(expectedOutput, myOut.toString());
    }
}