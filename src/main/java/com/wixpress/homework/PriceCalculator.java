package com.wixpress.homework;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class PriceCalculator {
    public static final String OM = "OM", DH = "DH", LP = "LP";

    public static final String SMALL = "S", MEDIUM = "M", LARGE = "L";

    public static final String OM_S = "1";
    public static final String OM_L = "7.20";
    public static final String DH_S = "0.90";
    public static final String DH_M = "3.40";
    public static final String LP_S = "1.23";
    public static final String LP_M = "3";
    public static final String LP_L = "7";

    DecimalFormat numberFormat = new DecimalFormat("0.00");

    public String getPrice(String transaction) {
        String provider = transaction.substring(13, 15);
        String size = transaction.substring(11, 12);
        String price = "ERROR";

        //-------------------------------------------------------------------
//        String month = transaction.substring(5, 7);
//        String priceP;
//        String discountD;
//        String monthCount = "00";
//        int discountCount = 0;
//        double fullDiscount;
        //-------------------------------------------------------------------

        if (isValidDate(transaction)) {
            price = getPrice(provider, size);

            //-------------------------------------------------------------------
//            if (!price.equals("ERROR")) {
//                priceP = price.substring(0, 4);
//                discountD = price.substring(5, 9);
//
//                if (month.equals(monthCount) && discountCount == 2) {
//                    fullDiscount = Double.parseDouble(priceP) + Double.parseDouble(discountD);
//                    price = " 0 " + fullDiscount;
//                }
//                if (month.equals(monthCount)) discountCount++;
//                else monthCount = month;
//            }
            //-------------------------------------------------------------------
        }

        transaction += " " + price;
        return transaction;
    }

    private boolean isValidDate(String order) {
        String date = order.substring(0, 10);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        format.setLenient(false);

        try {
            format.parse(date);
        }
        catch (ParseException e) {
            return false;
        }
        return true;
    }

    private String getPrice(String provider, String size) {
        if (provider.equals(OM)) {
            if (size.equals(SMALL)) return discountedPrice(OM_S);
            if (size.equals(LARGE)) return discountedPrice(OM_L);
        }
        if (provider.equals(DH)) {
            if (size.equals(SMALL)) return discountedPrice(DH_S);
            if (size.equals(MEDIUM)) return discountedPrice(DH_M);
        }
        if (provider.equals(LP)) {
            if (size.equals(SMALL)) return discountedPrice(LP_S);
            if (size.equals(MEDIUM)) return discountedPrice(LP_M);
            if (size.equals(LARGE)) return discountedPrice(LP_L);
        }
        return "ERROR";
    }

    private String discountedPrice(String priceStr) {
        double priceNum = Double.parseDouble(priceStr);
        double lpSmall = Double.parseDouble(LP_S);
        double lpMedium = Double.parseDouble(LP_M);
        double lpLarge = Double.parseDouble(LP_L);
        double omSmall = Double.parseDouble(OM_S);
        double dhSmall = Double.parseDouble(DH_S);

        if (priceNum == lpSmall || priceNum == dhSmall || priceNum == omSmall) {
            priceNum = Math.min(Math.min(lpSmall, dhSmall), omSmall);
        }
        if (priceNum == lpSmall || priceNum == lpMedium || priceNum == lpLarge) {
            priceNum = priceNum - priceNum * 0.10;
        }

        String priceDec = numberFormat.format(priceNum);
        String discountDec = numberFormat.format(Double.parseDouble(priceStr) - priceNum);

        return  priceDec + " " + discountDec;
    }
}

