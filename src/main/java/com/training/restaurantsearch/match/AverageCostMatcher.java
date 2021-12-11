package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;

public class AverageCostMatcher implements RestaurantAttributeMatcher {

    @Override
    public boolean matches(Restaurant restaurant, SearchCriteria criteria) {
        return criteria.getAverageCost() == null || restaurant.getAverageCost() <= criteria.getAverageCost();
    }
}
