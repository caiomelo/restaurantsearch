package com.training.restaurantsearch.usecase.sort.compare;

import com.training.restaurantsearch.domain.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AverageCostComparatorTest {

    private final Comparator<Restaurant> comparator = new AverageCostComparator();

    @Test
    void itShouldIdentifyWhenARestaurantHasLowerAverageCostThanAnotherOne() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setAverageCost(LOW_AVERAGE_COST);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setAverageCost(HIGH_AVERAGE_COST);

        assertEquals(LEFT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant1, restaurant2));
    }

    @Test
    void itShouldIdentifyWhenARestaurantHasGreaterAverageCostThanAnotherOne() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setAverageCost(HIGH_AVERAGE_COST);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setAverageCost(LOW_AVERAGE_COST);

        assertEquals(RIGHT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant1, restaurant2));
    }

    @Test
    void itShouldIdentifyWhenTwoRestaurantsHaveEqualAverageCost() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setAverageCost(LOW_AVERAGE_COST);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setAverageCost(LOW_AVERAGE_COST);

        assertEquals(TIE_VALUE, comparator.compare(restaurant1, restaurant2));
    }

    private static final int LEFT_SIDE_PRECEDES_VALUE = -1;
    private static final int RIGHT_SIDE_PRECEDES_VALUE = 1;
    private static final int TIE_VALUE = 0;
    private static final int LOW_AVERAGE_COST = 10;
    private static final int HIGH_AVERAGE_COST = 20;

}