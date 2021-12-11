package com.training.restaurantsearch.compare;

import com.training.restaurantsearch.domain.Restaurant;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Restaurant> {

    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        return Integer.compare(o1.getDistance(), o2.getDistance());
    }
}
