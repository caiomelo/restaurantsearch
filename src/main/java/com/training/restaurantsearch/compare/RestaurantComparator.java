package com.training.restaurantsearch.compare;

import com.training.restaurantsearch.domain.Restaurant;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RestaurantComparator implements Comparator<Restaurant> {

    private final List<Comparator<Restaurant>> comparators = Arrays.asList(
            new DistanceComparator(), new CustomerRatingComparator(), new AverageCostComparator());

    @Override
    public int compare(Restaurant o1, Restaurant o2) {
        for (Comparator<Restaurant> comparator : comparators) {
            int comparison = comparator.compare(o1, o2);
            if (comparison != 0) return comparison;
        }

        return 0;
    }
}
