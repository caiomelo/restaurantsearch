package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RestaurantMatcherTest {

    private final RestaurantAttributeMatcher attributeMatcher1 = mock(RestaurantAttributeMatcher.class);
    private final RestaurantAttributeMatcher attributeMatcher2 = mock(RestaurantAttributeMatcher.class);
    private final RestaurantMatcher restaurantMatcher = new RestaurantMatcher(Arrays.asList(attributeMatcher1, attributeMatcher2));
    private final Restaurant restaurant = new Restaurant();
    private final SearchCriteria criteria = new SearchCriteria(null, null, null, null, null);

    @Test
    void itShouldMatchIfAllAttributeFromCriteriaMatch() {
        when(attributeMatcher1.matches(restaurant, criteria)).thenReturn(true);
        when(attributeMatcher2.matches(restaurant, criteria)).thenReturn(true);

        assertTrue(restaurantMatcher.matches(restaurant, criteria));
    }

    @Test
    void itShouldNotMatchIfAnyAttributeFromTheCriteriaDoesNotMatch() {
        when(attributeMatcher1.matches(restaurant, criteria)).thenReturn(true);
        when(attributeMatcher2.matches(restaurant, criteria)).thenReturn(false);

        assertFalse(restaurantMatcher.matches(restaurant, criteria));
    }
}