package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;

public class NameMatcher implements RestaurantAttributeMatcher {

    @Override
    public boolean matches(Restaurant restaurant, SearchCriteria criteria) {
        return criteria.getName() == null || restaurant.getName().contains(criteria.getName());
    }
}
