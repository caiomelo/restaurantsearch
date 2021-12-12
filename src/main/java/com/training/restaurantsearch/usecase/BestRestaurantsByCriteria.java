package com.training.restaurantsearch.usecase;

import com.training.restaurantsearch.dataprovider.RestaurantsRepository;
import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;
import com.training.restaurantsearch.sort.RestaurantSorter;

import java.util.List;

public class BestRestaurantsByCriteria {

    public BestRestaurantsByCriteria(RestaurantsRepository repository, RestaurantSorter sorter) {
        this.repository = repository;
        this.sorter = sorter;
    }

    private final RestaurantsRepository repository;
    private final RestaurantSorter sorter;

    public List<Restaurant> execute(SearchCriteria criteria) {
        List<Restaurant> restaurants = repository.getByCriteria(criteria);
        if (restaurants.size() > 5) {
            return sorter.sort(restaurants).subList(0, 5);
        }
        return restaurants;
    }

}
