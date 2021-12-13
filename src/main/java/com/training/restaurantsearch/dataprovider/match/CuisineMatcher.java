package com.training.restaurantsearch.dataprovider.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.usecase.SearchCriteria;

public class CuisineMatcher implements RestaurantAttributeMatcher {

    @Override
    public boolean matches(Restaurant restaurant, SearchCriteria criteria) {
        return criteria.getCuisine() == null || restaurant.getCuisine().contains(criteria.getCuisine());
    }
}
