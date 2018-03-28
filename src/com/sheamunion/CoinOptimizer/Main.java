package com.sheamunion.CoinOptimizer;

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
            Double value = Double.valueOf(strippedArg);

            Map<String, Integer> result = optimizer.optimize(value * 100);

            view.displayResults(result);
        } catch (NumberFormatException nfe) {
            view.displayInvalidInput();
        }
    }
}