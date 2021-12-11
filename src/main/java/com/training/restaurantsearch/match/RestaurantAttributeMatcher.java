package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;

public interface RestaurantAttributeMatcher {

    boolean matches(Restaurant restaurant, SearchCriteria criteria);

}
