package com.example.profitcalculator;

import static com.example.profitcalculator.Constant.*;

class DynamicProgrammingSolution {

    int getMaxProfit(int[] stockPrices) {

        long len = stockPrices.length;
        checkStockPricesLengthValidity(len);
        int maxProfit = stockPrices[1] - stockPrices[0];
        if (MIN_PRICES_LENGTH == len) return maxProfit;
        int minPrice = Math.min(stockPrices[0], stockPrices[1]);

        for (int i = 2; i < len; i++) {
            int currentPrice = stockPrices[i];
            if (currentPrice < 0) {
                throw new IllegalArgumentException(String.format("%d is invalid maxProfit price, it should be more than 0",
                        currentPrice));
            }

            int currentProfit = currentPrice - minPrice;
            maxProfit = calculateMaxProfit(maxProfit, currentProfit);
            minPrice = calculateMinPrice(minPrice, currentPrice);
        }
        return maxProfit;
    }

    private int calculateMaxProfit(int maxProfit, int currentProfit) {
        return Math.max(maxProfit, currentProfit); // taking origin maxProfit when maxProfit = currentProfit
    }

    private int calculateMinPrice(int minPrice, int currentPrice) {
        return Math.min(minPrice, currentPrice); // taking origin minPrice when minPrice = currentPrice
    }

    private void checkStockPricesLengthValidity(long len) {
        if (len < MIN_PRICES_LENGTH) {
            throw new IllegalArgumentException(String.format("maxProfit prices need to include at lest %d indices, but there is %d",
                    MIN_PRICES_LENGTH, len));
        }
    }


}
