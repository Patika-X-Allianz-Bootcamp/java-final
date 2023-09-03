package com.tourismcorp.healthtourism.util;

public class FlightIdGenerator {

    private static final long INITIAL_VALUE = 1000;
    private static final long INCREMENT_SIZE = 100;
    private static long currentValue = INITIAL_VALUE;


    public static String getFlightNumber() {
        currentValue += INCREMENT_SIZE;
        return "TK" + "-" + currentValue + "-" + Math.round(Math.random() * 1000000);
    }

}
