package com.sheamunion.CoinOptimizer;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IllegalArgumentException {
        View view = new View();

        if (args.length != 1) {
            view.displayUsage();
            throw new IllegalArgumentException("Please provide only one dollar value.");
        }

        try {
            CoinOptimizer optimizer = new CoinOptimizer();

            String strippedArg = args[0].replaceAll("[^\\d.]", "");
            BigDecimal value = new BigDecimal(strippedArg).multiply(new BigDecimal("100"));

            Map<String, BigDecimal> result = optimizer.optimize(value);

            view.displayResults(result);
        } catch (NumberFormatException nfe) {
            view.displayInvalidInput();
        }
    }
}