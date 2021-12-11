package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRatingMatcherTest {

    private final RestaurantAttributeMatcher matcher = new CustomerRatingMatcher();
    private SearchCriteria criteria = new SearchCriteria(null, null, null, CRITERIA_VALUE, null);

    @Test
    void itShouldIdentifyAMatchIfNoCustomerRatingCriteriaIsGiven() {
        Restaurant restaurant = new Restaurant();
        criteria = new SearchCriteria(null, null, null, null, null);

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyAMatchIfTheCustomerRatingFromTheRestaurantIsEqualToTheSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setCustomerRating(CRITERIA_VALUE);

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyAMatchIfTheCustomerRatingFromTheRestaurantIsHigherThanTheSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setCustomerRating(HIGHER_THAN_CRITERIA_VALUE);

        assertTrue(matcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldIdentifyANonMatchIfTheCustomerRatingFromTheRestaurantIsLowerThanTheSearchCriteria() {
        Restaurant restaurant = new Restaurant();
        restaurant.setCustomerRating(LOWER_THAN_CRITERIA_VALUE);

        assertFalse(matcher.matches(restaurant, criteria));
    }

    private static final int LOWER_THAN_CRITERIA_VALUE = 2;
    private static final int HIGHER_THAN_CRITERIA_VALUE = 4;
    private static final int CRITERIA_VALUE = 3;

}