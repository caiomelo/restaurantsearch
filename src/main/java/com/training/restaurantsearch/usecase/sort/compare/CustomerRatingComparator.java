package com.training.restaurantsearch.usecase.sort.compare;

import com.training.restaurantsearch.domain.Restaurant;

import java.util.Comparator;

public class CustomerRatingComparator implements Comparator<Restaurant> {

    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        return Integer.compare(o2.getCustomerRating(), o1.getCustomerRating());
    }
}
