package com.training.restaurantsearch.dataprovider.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.usecase.SearchCriteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DistanceMatcherTest {

    private final RestaurantAttributeMatcher matcher = new DistanceMatcher();
    private SearchCriteria criteria = new SearchCriteria(null, null, CRITERIA_VALUE, null, null);

    @Test
    void itShouldIdentifyAMatchIfNoDistanceCriteriaIsGiven() {
        Restaurant restaurant = new Restaurant();
        criteria = new SearchCriteria(null, null, null, null, null);

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyAMatchIfTheDistanceFromTheRestaurantIsEqualToTheSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setDistance(CRITERIA_VALUE);

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyAMatchIfTheDistanceFromTheRestaurantIsLowerThanTheSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setDistance(LOWER_THAN_CRITERIA_VALUE);

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyANonMatchIfTheDistanceFromTheRestaurantIsHigherThanTheSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setDistance(HIGHER_THAN_CRITERIA_VALUE);

        assertFalse(matcher.matches(restaurant, criteria));
    }

    private static final int LOWER_THAN_CRITERIA_VALUE = 20;
    private static final int HIGHER_THAN_CRITERIA_VALUE = 35;
    private static final int CRITERIA_VALUE = 30;

}