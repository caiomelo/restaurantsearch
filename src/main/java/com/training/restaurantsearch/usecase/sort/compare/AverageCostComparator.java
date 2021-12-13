package com.training.restaurantsearch.usecase.sort.compare;

import com.training.restaurantsearch.domain.Restaurant;

import java.util.Comparator;

public class AverageCostComparator implements Comparator<Restaurant> {

    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        return o1.getAverageCost().compareTo(o2.getAverageCost());
    }
}
