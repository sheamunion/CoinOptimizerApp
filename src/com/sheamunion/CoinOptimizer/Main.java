package com.sheamunion.CoinOptimizer;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        CoinOptimizer optimizer = new CoinOptimizer();

        if (args.length != 1) {
            view.displayWelcome();
            view.displayUseage();

            System.exit(1);
        }

        try {
            String strippedArg = args[0].replaceAll("[^\\d.,]", "");
            BigDecimal value = new BigDecimal(strippedArg).multiply(new BigDecimal("100"));

            Map<String, BigDecimal> result = optimizer.optimize(value);

            view.displayResults(result);
        } catch (NumberFormatException nfe) {
            view.displayInvalidInput();
        }
    }
}