package com.sheamunion.CoinOptimizer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewTest {

    private View view;

    @Before
    public void setUp() throws Exception {
        view = new View();
    }

    @Test
    public void displaysHowToUseTheCLI() throws Exception {
        String expectedOutput = "Useage: java com.sheamunion.CoinOptimizer.Main <dollarValue>";

        String output = view.displayUseage();

        assertEquals(expectedOutput, output);
    }
}