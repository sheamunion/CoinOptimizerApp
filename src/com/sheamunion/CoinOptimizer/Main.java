package com.sheamunion.CoinOptimizer;

public class Main {

    public static void main(String[] args) {
        View view = new View();

        if (args.length == 0) {
            System.out.printf("Welcome! Get the optimal coin combination for a dollar value. %n %s", view.displayUseage());
            System.exit(1);
        }
    }
}