package com.wixpress.homework;

import java.util.Arrays;
import java.util.List;

public final class ShippingCalculator {

    public static final List<String> TRANSACTIONS = Arrays.asList(
            "2021-06-01 S LP",
            "2021-06-01 M DH",
            "2021-06-02 M LP",
            "2021-06-03 L DH",
            "2021-06-05 S LP",
            "2021-06-08 L LP",
            "2021-06-14 M DH",
            "2021-06-19 S LP",
            "2021-06-22 S LP",
            "2021-06-25 M DH",
            "2021-06-26 L LP",
            "2021-06-31 S OM",
            "2021-07-01 L LP",
            "2021-07-05 S OM",
            "2021-07-08 L LP",
            "2021-07-12 R LP",
            "2021-07-14 M DH",
            "2021-07-19 S OM",
            "2021-07-22 S LP",
            "2021-07-23 L DH"
    );

    /**
     * For this task you have to implement getPrice method of PriceCalculator class.
     * Transactions are already loaded and stored in TRANSACTIONS variable.
     * Each is already passed to the PriceCalculator and response is printed out.
     * There is also one test written PriceCalculatorTest.
     */

    public static void main(String[] args) {
        final PriceCalculator priceCalculator = new PriceCalculator();
        for (String transaction : TRANSACTIONS) {
            final String transactionWithPrice = priceCalculator.getPrice(transaction);
            System.out.println(transactionWithPrice);
        }
    }
}
