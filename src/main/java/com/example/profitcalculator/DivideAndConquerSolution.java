package com.example.profitcalculator;

import java.util.Arrays;

import static com.example.profitcalculator.Constant.MIN_PRICES_LENGTH;

class DivideAndConquerSolution {

    int getMaxProfit(int[] stockPrices) {

        DynamicProgrammingSolution dynamicProgrammingSolution = new DynamicProgrammingSolution();

        long len = stockPrices.length;
        if (len < MIN_PRICES_LENGTH) {
            throw new IllegalArgumentException(String.format("maxProfit prices need to include at lest %d indices, but there is %d",
                    MIN_PRICES_LENGTH, len));
        }
        if (MIN_PRICES_LENGTH == len) return stockPrices[1] - stockPrices[0];

        int startIndex = 0;
        int endIndex = stockPrices.length;
        int midIndex = (startIndex + endIndex) / 2;

        int[] firstArray = getSplitArray(stockPrices, startIndex, midIndex);
        int[] secondArray = getSplitArray(stockPrices, midIndex + 1, endIndex);

        // part 1: buy and sale prices come from first array, the max profit is calculated in first array
        int firstArrayMax = dynamicProgrammingSolution.getMaxProfit(firstArray);

        // part 2:  buy and sale prices come from second array, the max profit is calculated in second array
        int secondArrayMax = dynamicProgrammingSolution.getMaxProfit(secondArray);

        // part 3: buy price as min comes from first array, sale price as max comes from second array, the max profit is (max - min)
        int min = findMin(firstArray);
        int max = findMax(secondArray);
        int diffArrayMax = max - min;

        return (firstArrayMax > secondArrayMax ? firstArrayMax : secondArrayMax) > diffArrayMax ?
                (firstArrayMax > secondArrayMax ? firstArrayMax : secondArrayMax) : diffArrayMax;
    }

    private int[] getSplitArray(int[] stockPrices, int start, int end) {
        return Arrays.copyOfRange(stockPrices, start, end);
    }

    private int findMin(int[] firstArray) {
        return Arrays.stream(firstArray).min().getAsInt();
    }

    private int findMax(int[] secondArray) {
        return Arrays.stream(secondArray).max().getAsInt();
    }
}
