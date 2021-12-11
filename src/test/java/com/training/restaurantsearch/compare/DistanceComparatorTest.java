package com.training.restaurantsearch.compare;

import com.training.restaurantsearch.domain.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceComparatorTest {

    private final Comparator<Restaurant> comparator = new DistanceComparator();

    @Test
    void itShouldIdentifyWhenARestaurantIsCloserThanAnotherOne() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setDistance(LOW_DISTANCE);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setDistance(HIGH_DISTANCE);

        assertEquals(LEFT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant1, restaurant2));
    }

    @Test
    void itShouldIdentifyWhenARestaurantIsFurtherThanAnotherOne() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setDistance(HIGH_DISTANCE);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setDistance(LOW_DISTANCE);

        assertEquals(RIGHT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant1, restaurant2));
    }

    @Test
    void itShouldIdentifyWhenTwoRestaurantsAreEquallyDistant() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setDistance(LOW_DISTANCE);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setDistance(LOW_DISTANCE);

        assertEquals(TIE_VALUE, comparator.compare(restaurant1, restaurant2));
    }

    private static final int LEFT_SIDE_PRECEDES_VALUE = -1;
    private static final int RIGHT_SIDE_PRECEDES_VALUE = 1;
    private static final int TIE_VALUE = 0;
    private static  final int LOW_DISTANCE = 10;
    private static  final int HIGH_DISTANCE = 20;

}