package com.training.restaurantsearch.usecase;

import com.training.restaurantsearch.domain.Restaurant;

import java.util.List;

public interface BestRestaurantsByCriteria {

    List<Restaurant> execute(SearchCriteria criteria);

}
