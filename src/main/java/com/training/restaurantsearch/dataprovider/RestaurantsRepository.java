package com.training.restaurantsearch.dataprovider;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;

import java.util.List;

public interface RestaurantsRepository {

    List<Restaurant> getByCriteria(SearchCriteria criteria);

}
