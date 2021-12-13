package com.training.restaurantsearch.dataprovider.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.usecase.SearchCriteria;

public class DistanceMatcher implements RestaurantAttributeMatcher {

    @Override
    public boolean matches(Restaurant restaurant, SearchCriteria criteria) {
        return criteria.getDistance() == null || restaurant.getDistance() <= criteria.getDistance();
    }
}
