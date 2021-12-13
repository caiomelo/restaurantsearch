package com.training.restaurantsearch.usecase;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;

import java.util.List;

public interface BestRestaurantsByCriteria {

    List<Restaurant> execute(SearchCriteria criteria);

}
