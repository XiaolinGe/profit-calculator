package com.example.profitcalculator;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.Assert.assertEquals;

public class ComparePerformanceTest {

    private DynamicProgrammingSolution dynamicProgrammingSolution = new DynamicProgrammingSolution();
    private DivideAndConquerSolution divideAndConquerSolution = new DivideAndConquerSolution();

    private int arrayLen = 100000;
    private int[] stockPrices = createSpecificStockPricesArray(arrayLen); // {1, 2, 3, 4, ... 99997, 99998, 99999, 100000}

    @Test
    public void happy_test_with_dynamic_programming_solution() {

        Instant start = Instant.now();

        int givenRes = dynamicProgrammingSolution.getMaxProfit(stockPrices);
        int expectedRes = arrayLen - 1;

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Dynamic Programming Solution: it takes " + timeElapsed.toMillis() +
                " milliseconds to calculate the max profit in an array containing " + arrayLen + " prices");

        assertEquals(expectedRes, givenRes);
    }


    @Test
    public void happy_test_with_divide_and_conquer_solution() {

        Instant start = Instant.now();

        int givenRes = divideAndConquerSolution.getMaxProfit(stockPrices);
        int expectedRes = arrayLen - 1;

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Divide And Conquer Solution: it takes " + timeElapsed.toMillis() +
                " milliseconds to calculate the max profit in an array containing " + arrayLen + " prices");

        assertEquals(expectedRes, givenRes);
    }

    private int[] createSpecificStockPricesArray(int arrayLength) {
        int[] initialStockPrices = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] stockPrices = new int[arrayLength];
        System.arraycopy(initialStockPrices, 0, stockPrices, 0, initialStockPrices.length);
        for (int i = initialStockPrices.length + 1; i < arrayLength; i++) {
            stockPrices[i] = i;
        }
        return stockPrices;
    }

}
