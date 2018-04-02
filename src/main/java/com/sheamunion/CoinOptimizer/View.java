package com.sheamunion.CoinOptimizer;

import java.math.BigDecimal;
import java.util.Map;

public class View {

    public View() {}

    public void displayUsage() {
        System.out.println("Usage: java -jar com.sheamunion.CoinOptimizer.Main <dollarValue>\n - <dollarValue> formats: 3000.50 or \\$3,000.50 or '$3'");
    }

    public void displayInvalidInput() {
        System.out.println("Please enter a well formatted dollar value.\n - <dollarValue> formats: 3000.50 or \\$3,000.50 or '$3'");
    }

    public void displayResults(Map<String, BigDecimal> result) {
        System.out.printf("Your dollar value has been optimized. %n %s %n", result);
    }
}
