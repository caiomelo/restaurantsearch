package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;

public class CustomerRatingMatcher implements RestaurantAttributeMatcher {

    @Override
    public boolean matches(Restaurant restaurant, SearchCriteria criteria) {
        return criteria.getCustomerRating() == null || restaurant.getCustomerRating() >= criteria.getCustomerRating();
    }
}
