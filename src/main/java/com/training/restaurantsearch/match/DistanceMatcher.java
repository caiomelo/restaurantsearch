package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;

public class DistanceMatcher implements RestaurantAttributeMatcher {

    @Override
    public boolean matches(Restaurant restaurant, SearchCriteria criteria) {
        return criteria.getDistance() == null || restaurant.getDistance() <= criteria.getDistance();
    }
}
