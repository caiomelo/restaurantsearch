package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CuisineMatcherTest {

    private final RestaurantAttributeMatcher matcher = new CuisineMatcher();
    private SearchCriteria criteria = new SearchCriteria(null, CRITERIA_VALUE, null, null, null);

    @Test
    void itShouldIdentifyAMatchIfNoAverageCostCriteriaIsGiven() {
        Restaurant restaurant = new Restaurant();
        criteria = new SearchCriteria(null, null, null, null, null);

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyAMatchIfTheRestaurantCuisineContainsTheCuisineSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setCuisine("Italian");

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyANonMatchIfTheRestaurantCuisineDoesNotContainsTheCuisineSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setCuisine("Japanese");

        assertFalse(matcher.matches(restaurant, criteria));
    }

    private static final String CRITERIA_VALUE = "alian";

}