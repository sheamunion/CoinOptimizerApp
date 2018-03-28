package com.sheamunion.CoinOptimizer;

import java.util.Map;

public class View {

    public View() {}

    public void displayWelcome() {
        System.out.println("Welcome! Get the optimal coin combination for a dollar value.");
    }

    public void displayUseage() {
        System.out.println("Useage: java com.sheamunion.CoinOptimizer.Main <dollarValue>");
    }

    public void displayResults(Map<String, Integer> result) {
        System.out.printf("Your dollar value has been optimized. %n %s", result);
    }
}
