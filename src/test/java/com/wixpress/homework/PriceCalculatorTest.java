package com.wixpress.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {


    @Test
    public void testPriceCalculation() {
        final PriceCalculator priceCalculator = new PriceCalculator();

        assertEquals("2021-07-15 S LP 0.90 0.33", priceCalculator.getPrice("2021-07-15 S LP"));
        assertEquals("2021-02-13 M DH 3.40 0.00", priceCalculator.getPrice("2021-02-13 M DH"));
        assertEquals("2021-02-30 L DH ERROR", priceCalculator.getPrice("2021-02-30 L DH"));   //DH doesn't have L size
        assertEquals("2018-04-31 M DH ERROR", priceCalculator.getPrice("2018-04-31 M DH"));   //april 31st doesn't exist
        assertEquals("2020-05-01 M LD ERROR", priceCalculator.getPrice("2020-05-01 M LD"));   //wrong provider
        assertEquals("2020-01-01 L LP 6.30 0.70", priceCalculator.getPrice("2020-01-01 L LP"));
        assertEquals("2021-01-15 S LP 0.90 0.33", priceCalculator.getPrice("2021-01-15 S LP"));
//        assertEquals("2020-01-01 S OM 0 1.00", priceCalculator.getPrice("2020-01-01 S OM"));

    }
}