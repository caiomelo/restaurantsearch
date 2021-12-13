package com.training.restaurantsearch.usecase.sort;

import com.training.restaurantsearch.domain.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RestaurantSorterTest {

    private final RestaurantSorter sorter = new RestaurantSorter();

    @Test
    void itShouldCorrectlySortRestaurantsByDistance() {
        List<Restaurant> restaurants = buildRestaurantsWithDifferentDistance();
        List<Restaurant> sorted = sorter.sort(restaurants);
        assertEquals(restaurants.get(0), sorted.get(1));
        assertEquals(restaurants.get(1), sorted.get(0));
    }

    @Test
    void itShouldCorrectlySortRestaurantsByCustomerRating() {
        List<Restaurant> restaurants = buildRestaurantsWithDifferentRating();
        List<Restaurant> sorted = sorter.sort(restaurants);
        assertEquals(restaurants.get(0), sorted.get(1));
        assertEquals(restaurants.get(1), sorted.get(0));
    }

    @Test
    void itShouldCorrectlySortRestaurantsByAverageCost() {
        List<Restaurant> restaurants = buildRestaurantsWithDifferentAvgCost();
        List<Restaurant> sorted = sorter.sort(restaurants);
        assertEquals(restaurants.get(0), sorted.get(1));
        assertEquals(restaurants.get(1), sorted.get(0));
    }

    private List<Restaurant> buildRestaurantsWithDifferentDistance() {
        return Arrays.asList(
                new Restaurant("B", "Jap", 15, 3, 30),
                new Restaurant("A", "Thai", 10, 3, 30)
        );
    }

    private List<Restaurant> buildRestaurantsWithDifferentRating() {
        return Arrays.asList(
                new Restaurant("B", "Jap", 15, 2, 30),
                new Restaurant("A", "Thai", 15, 3, 30)
        );
    }

    private List<Restaurant> buildRestaurantsWithDifferentAvgCost() {
        return Arrays.asList(
                new Restaurant("B", "Jap", 15, 3, 35),
                new Restaurant("A", "Thai", 15, 3, 30)
        );
    }
}