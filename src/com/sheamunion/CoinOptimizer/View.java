package com.sheamunion.CoinOptimizer;

import java.util.Map;

public class View {

    public View() {}

    public void displayWelcome() {
        System.out.println("Welcome! Get the optimal coin combination for a dollar value.");
    }

    public void displayUseage() {
        System.out.println("Useage: java com.sheamunion.CoinOptimizer.Main <dollarValue>\n - <dollarValue> formats: 3000.50 or \\$3,000.50 or '$3'");
    }

    public void displayInvalidInput() {
        System.out.println("Please enter a well formatted dollar value.\n - <dollarValue> formats: 3000.50 or \\$3,000.50 or '$3'");
    }

    public void displayResults(Map<String, Integer> result) {
        System.out.printf("Your dollar value has been optimized. %n %s", result);
    }
}
