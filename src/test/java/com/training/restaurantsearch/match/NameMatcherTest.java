package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameMatcherTest {

    private final RestaurantAttributeMatcher matcher = new NameMatcher();
    private SearchCriteria criteria = new SearchCriteria(CRITERIA_VALUE, null, null, null, null);

    @Test
    void itShouldIdentifyAMatchIfNameCriteriaIsGiven() {
        Restaurant restaurant = new Restaurant();
        criteria = new SearchCriteria(null, null, null, null, null);

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyAMatchIfTheRestaurantNameContainsTheCuisineSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Fogo de chao");

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyANonMatchIfTheRestaurantNameDoesNotContainsTheCuisineSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Alfredo's");

        assertFalse(matcher.matches(restaurant, criteria));
    }

    private static final String CRITERIA_VALUE = "chao";

}