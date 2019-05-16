package com.example.profitcalculator;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] stockPrices = {10, 7, 5, 8, 11, 9};
        dynamicProgrammingSolution(stockPrices);
        divideAndConquerSolution(stockPrices);
    }

    private static void dynamicProgrammingSolution(int[] stockPrices) {
        DynamicProgrammingSolution dps = new DynamicProgrammingSolution();

        Instant start = Instant.now();
        int maxProfitDps = dps.getMaxProfit(stockPrices);
        Instant end = Instant.now();
        calculateTime(start, end, "Dynamic Programming Solution", maxProfitDps, Arrays.toString(stockPrices));
    }

    private static void divideAndConquerSolution(int[] stockPrices) {
        DivideAndConquerSolution dacs = new DivideAndConquerSolution();

        Instant start = Instant.now();
        int maxProfitDacs = dacs.getMaxProfit(stockPrices);
        Instant end = Instant.now();
        calculateTime(start, end, "Divide And Conquer Solution", maxProfitDacs, Arrays.toString(stockPrices));
    }

    private static void calculateTime(Instant start, Instant end, String solutionName, int maxProfit, String stockPricesStr) {
        Duration timeElapsed = Duration.between(start, end);
        System.out.println(solutionName + ": it takes " + timeElapsed.toMillis() +
                " milliseconds to calculate the max profit is " + maxProfit + " in array " + stockPricesStr);
    }

}

