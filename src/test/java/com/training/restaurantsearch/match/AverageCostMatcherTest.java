package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AverageCostMatcherTest {

    private final RestaurantAttributeMatcher matcher = new AverageCostMatcher();
    private SearchCriteria criteria = new SearchCriteria(null, null, null, null, CRITERIA_VALUE);

    @Test
    void itShouldIdentifyAMatchIfNoAverageCostCriteriaIsGiven() {
        Restaurant restaurant = new Restaurant();
        criteria = new SearchCriteria(null, null, null, null, null);

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyAMatchIfTheAverageCostFromTheRestaurantIsEqualToTheSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setAverageCost(CRITERIA_VALUE);

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyAMatchIfTheAverageCostFromTheRestaurantIsLowerThanTheSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setAverageCost(LOWER_THAN_CRITERIA_VALUE);

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyANonMatchIfTheAverageCostFromTheRestaurantIsHigherThanTheSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setAverageCost(HIGHER_THAN_CRITERIA_VALUE);

        assertFalse(matcher.matches(restaurant, criteria));
    }

    private static final int LOWER_THAN_CRITERIA_VALUE = 20;
    private static final int HIGHER_THAN_CRITERIA_VALUE = 35;
    private static final int CRITERIA_VALUE = 30;

}