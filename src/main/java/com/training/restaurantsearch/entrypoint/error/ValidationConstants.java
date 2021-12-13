package com.training.restaurantsearch.entrypoint.error;

public final class ValidationConstants {

    private ValidationConstants() {
    }

    public static final String DISTANCE_MESSAGE = "Distance must be a value between 1 and 10 (miles)";
    public static final int DISTANCE_MIN = 1;
    public static final int DISTANCE_MAX = 10;
    public static final String CUSTOMER_RATING_MESSAGE = "Rating must be a value between 1 and 5 (stars)";
    public static final int CUSTOMER_RATING_MIN = 1;
    public static final int CUSTOMER_RATING_MAX = 5;
    public static final String AVERAGE_COST_MESSAGE = "Average cost must be a value between 10 and 50 ($)";
    public static final int AVERAGE_COST_MIN = 10;
    public static final int AVERAGE_COST_MAX = 50;

}
