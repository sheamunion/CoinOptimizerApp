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

        Map<String, Integer> result = optimizer.optimize(Double.parseDouble(args[0]) * 100);

        view.displayResults(result);
    }
}