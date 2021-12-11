package com.training.restaurantsearch.sort;

import com.training.restaurantsearch.compare.RestaurantComparator;
import com.training.restaurantsearch.domain.Restaurant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RestaurantSorter {

    private final Comparator<Restaurant> comparator = new RestaurantComparator();

    public List<Restaurant> sort(List<Restaurant> restaurants) {
        List<Restaurant> copy = new ArrayList<>(restaurants);
        copy.sort(comparator);
        return copy;
    }

}
