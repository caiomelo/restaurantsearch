package com.training.restaurantsearch.compare;

import com.training.restaurantsearch.domain.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestaurantComparatorTest {

    private final Comparator<Restaurant> comparator = new RestaurantComparator();

    @Test
    void itShouldIdentifyWhichRestaurantHasHigherPrecedenceByDistance() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setDistance(LOW_DISTANCE);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setDistance(HIGH_DISTANCE);

        assertEquals(LEFT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant1, restaurant2));
        assertEquals(RIGHT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant2, restaurant1));
    }

    @Test
    void itShouldIdentifyWhichRestaurantHasHigherPrecedenceByCustomerRating() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setDistance(LOW_DISTANCE);
        restaurant1.setCustomerRating(HIGH_RATING);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setDistance(LOW_DISTANCE);
        restaurant2.setCustomerRating(LOW_RATING);

        assertEquals(LEFT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant1, restaurant2));
        assertEquals(RIGHT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant2, restaurant1));
    }

    @Test
    void itShouldIdentifyWhichRestaurantHasHigherPrecedenceByAverageCost() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setDistance(LOW_DISTANCE);
        restaurant1.setCustomerRating(LOW_RATING);
        restaurant1.setAverageCost(LOW_AVG_COST);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setDistance(LOW_DISTANCE);
        restaurant2.setCustomerRating(LOW_RATING);
        restaurant2.setAverageCost(HIGH_AVG_COST);

        assertEquals(LEFT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant1, restaurant2));
        assertEquals(RIGHT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant2, restaurant1));
    }

    @Test
    void itShouldIdentifyWhenRestaurantsAreInATie() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setDistance(LOW_DISTANCE);
        restaurant1.setCustomerRating(LOW_RATING);
        restaurant1.setAverageCost(LOW_AVG_COST);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setDistance(LOW_DISTANCE);
        restaurant2.setCustomerRating(LOW_RATING);
        restaurant2.setAverageCost(LOW_AVG_COST);

        assertEquals(TIE_VALUE, comparator.compare(restaurant1, restaurant2));
    }

    private static final int LOW_DISTANCE = 10;
    private static final int HIGH_DISTANCE = 20;
    private static final int LOW_AVG_COST = 15;
    private static final int HIGH_AVG_COST = 25;
    private static final int LOW_RATING = 2;
    private static final int HIGH_RATING = 5;
    private static final int LEFT_SIDE_PRECEDES_VALUE = -1;
    private static final int RIGHT_SIDE_PRECEDES_VALUE = 1;
    private static final int TIE_VALUE = 0;

}