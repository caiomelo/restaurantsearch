package com.training.restaurantsearch.dataprovider.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.usecase.SearchCriteria;

public class AverageCostMatcher implements RestaurantAttributeMatcher {

    @Override
    public boolean matches(Restaurant restaurant, SearchCriteria criteria) {
        return criteria.getAverageCost() == null || restaurant.getAverageCost() <= criteria.getAverageCost();
    }
}
