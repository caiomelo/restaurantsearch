package com.training.restaurantsearch.dataprovider;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.usecase.RestaurantRepository;
import com.training.restaurantsearch.usecase.SearchCriteria;
import com.training.restaurantsearch.dataprovider.file.CuisineData;
import com.training.restaurantsearch.dataprovider.file.CuisineDataReader;
import com.training.restaurantsearch.dataprovider.file.RestaurantData;
import com.training.restaurantsearch.dataprovider.file.RestaurantDataReader;
import com.training.restaurantsearch.dataprovider.match.RestaurantMatcher;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@Repository
public class RestaurantInMemoryRepository implements RestaurantRepository {

    public RestaurantInMemoryRepository(RestaurantDataReader restaurantDataReader, CuisineDataReader cuisineDataReader,
                                        RestaurantMatcher matcher) {
        this.restaurantDataReader = restaurantDataReader;
        this.cuisineDataReader = cuisineDataReader;
        this.matcher = matcher;
        restaurants = new ArrayList<>();
    }

    private List<Restaurant> restaurants;
    private final RestaurantDataReader restaurantDataReader;
    private final CuisineDataReader cuisineDataReader;
    private final RestaurantMatcher matcher;

    @Override
    public List<Restaurant> getByCriteria(SearchCriteria criteria) {
        return restaurants.stream().filter(restaurant -> matcher.matches(restaurant, criteria)).collect(toList());
    }

    @PostConstruct
    public void initData() throws IOException {
        List<RestaurantData> restaurantData = restaurantDataReader.read();
        List<CuisineData> cuisineData = cuisineDataReader.read();
        restaurants = merge(restaurantData, cuisineData);

    }

    private List<Restaurant> merge(List<RestaurantData> restaurantData, List<CuisineData> cuisineData) {
        Map<Integer, String> cuisineById = cuisineData.stream()
                .collect(toUnmodifiableMap(CuisineData::getId, CuisineData::getName));

        return restaurantData.stream()
                .map(data -> new Restaurant(
                        data.getName(),
                        cuisineById.get(data.getCuisineId()),
                        data.getDistance(),
                        data.getCustomerRating(),
                        data.getPrice()))
                .collect(toUnmodifiableList());
    }
}
