package com.training.restaurantsearch.usecase;

import com.training.restaurantsearch.dataprovider.RestaurantRepository;
import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;
import com.training.restaurantsearch.sort.RestaurantSorter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BestRestaurantsByCriteriaTest {

    private final RestaurantRepository repository = mock(RestaurantRepository.class);
    private final RestaurantSorter sorter = mock(RestaurantSorter.class);
    private final SearchCriteria criteria = mock((SearchCriteria.class));
    private final BestRestaurantsByCriteria useCase = new BestRestaurantsByCriteria(repository, sorter);

    @Test
    void itShouldNotSortListsWithLessThanSixMatches() {
        List<Restaurant> restaurants = buildRestaurants(5);
        when(repository.getByCriteria(criteria)).thenReturn(restaurants);

        assertEquals(restaurants, useCase.execute(criteria));
        verify(repository, times(1)).getByCriteria(criteria);
        verifyNoInteractions(sorter);
    }

    @Test
    void itShouldSortListsWithMoreThantFiveMatchesAndReturnTheFirstFive() {
        List<Restaurant> restaurants = buildRestaurants(6);
        when(repository.getByCriteria(criteria)).thenReturn(restaurants);

        List<Restaurant> sorted = restaurants.subList(0, 5);
        when(sorter.sort(restaurants)).thenReturn(sorted);

        assertEquals(sorted, useCase.execute(criteria));
        verify(repository, times(1)).getByCriteria(criteria);
        verify(sorter, times(1)).sort(restaurants);
    }

    private List<Restaurant> buildRestaurants(int size) {
        List<Restaurant> restaurants = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            restaurants.add(new Restaurant(
                    UUID.randomUUID().toString().substring(0, 3),
                    UUID.randomUUID().toString().substring(0, 3),
                    random.nextInt(),
                    random.nextInt(),
                    random.nextInt())
            );
        }

        return restaurants;
    }
}