package com.example.profitcalculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.example.profitcalculator.Constant.MIN_PRICES_LENGTH;
import static org.junit.Assert.assertEquals;


public class DynamicProgrammingSolutionTest {
    private DynamicProgrammingSolution dynamicProgrammingSolution = new DynamicProgrammingSolution();

    @Test
    public void happy_test_with_max_profit() {

        int[] stockPrices = {10, 7, 5, 8, 11, 9};
        int givenRes = dynamicProgrammingSolution.getMaxProfit(stockPrices);
        int expectedRes = 6;

        assertEquals(expectedRes, givenRes);
    }

    @Test
    public void happy_test_with_max_profit_is_negative() {

        int[] stockPrices = {10, 9, 8, 7, 6, 5};
        int givenRes = dynamicProgrammingSolution.getMaxProfit(stockPrices);
        int expectedRes = -1;

        assertEquals(expectedRes, givenRes);
    }


    @Test
    public void edge_test_with_two_prices() {

        int[] stockPrices = {3, 5};
        int givenRes = dynamicProgrammingSolution.getMaxProfit(stockPrices);
        int expectedRes = 2;

        assertEquals(expectedRes, givenRes);
    }

    @Test
    public void edge_test_with_adjacent_two_prices_are_equal() {

        int[] stockPrices = {10, 5, 5, 8, 11, 9};
        int givenRes = dynamicProgrammingSolution.getMaxProfit(stockPrices);
        int expectedRes = 6;

        assertEquals(expectedRes, givenRes);
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void exception_test_with_having_negative_stock_price() {

        int[] stockPrices = {10, 7, -5, 8, 11, 9};
        String expectedRes = "-5 is invalid maxProfit price, it should be more than 0";

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(expectedRes);
        dynamicProgrammingSolution.getMaxProfit(stockPrices);
    }

    @Test
    public void exception_test_with_stock_prices_length_is_invalid() {

        int[] stockPrices = {10};
        String expectedRes = "maxProfit prices need to include at lest " + MIN_PRICES_LENGTH +
                " indices, but there is " + stockPrices.length;

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(expectedRes);
        dynamicProgrammingSolution.getMaxProfit(stockPrices);
    }

}
