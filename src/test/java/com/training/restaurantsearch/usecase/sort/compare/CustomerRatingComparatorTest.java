package com.training.restaurantsearch.usecase.sort.compare;

import com.training.restaurantsearch.domain.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRatingComparatorTest {

    private final Comparator<Restaurant> comparator = new CustomerRatingComparator();

    @Test
    void itShouldIdentifyWhenARestaurantHasLowerCustomerRatingThanAnotherOne() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setCustomerRating(LOW_RATING);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCustomerRating(HIGH_RATING);

        assertEquals(RIGHT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant1, restaurant2));
    }

    @Test
    void itShouldIdentifyWhenARestaurantHasGreaterAverageCostThanAnotherOne() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setCustomerRating(HIGH_RATING);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCustomerRating(LOW_RATING);

        assertEquals(LEFT_SIDE_PRECEDES_VALUE, comparator.compare(restaurant1, restaurant2));
    }

    @Test
    void itShouldIdentifyWhenTwoRestaurantsHaveEqualCustomerRating() {
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setCustomerRating(LOW_RATING);

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setCustomerRating(LOW_RATING);

        assertEquals(TIE_VALUE, comparator.compare(restaurant1, restaurant2));
    }

    private static final int LEFT_SIDE_PRECEDES_VALUE = -1;
    private static final int RIGHT_SIDE_PRECEDES_VALUE = 1;
    private static final int TIE_VALUE = 0;
    private static final int LOW_RATING = 2;
    private static final int HIGH_RATING = 5;

}