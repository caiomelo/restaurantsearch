package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;

public class CuisineMatcher implements RestaurantAttributeMatcher {

    @Override
    public boolean matches(Restaurant restaurant, SearchCriteria criteria) {
        return criteria.getCuisine() == null || restaurant.getCuisine().contains(criteria.getCuisine());
    }
}
