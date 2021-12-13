package com.training.restaurantsearch.dataprovider.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.usecase.SearchCriteria;

public interface RestaurantAttributeMatcher {

    boolean matches(Restaurant restaurant, SearchCriteria criteria);

}
