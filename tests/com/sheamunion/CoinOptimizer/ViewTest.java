package com.sheamunion.CoinOptimizer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
    public void displayWelcome() throws Exception {
        String expectedOutput = "Welcome! Get the optimal coin combination for a dollar value.\n";

        view.displayWelcome();

        assertEquals(expectedOutput, myOut.toString());
    }

    @Test
    public void displaysHowToUseTheCLI() throws Exception {
        String expectedOutput = "Useage: java com.sheamunion.CoinOptimizer.Main <dollarValue>\n";

        view.displayUseage();

        assertEquals(expectedOutput, myOut.toString());
    }

    @Test
    public void displaysResults() throws Exception {
        String expectedOutput = "Your dollar value has been optimized. \n {nickel=0, dime=2, half-dollar=1, silver-dollar=0, penny=4, quarter=1}";
        Map<String, Integer> result = new HashMap<>();
        result.put("silver-dollar", 0);
        result.put("half-dollar", 1);
        result.put("quarter", 1);
        result.put("dime", 2);
        result.put("nickel", 0);
        result.put("penny", 4);

        view.displayResults(result);

        assertEquals(expectedOutput, myOut.toString());
    }
}