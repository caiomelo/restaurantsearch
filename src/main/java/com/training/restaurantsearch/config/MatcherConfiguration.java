package com.training.restaurantsearch.config;

import com.training.restaurantsearch.dataprovider.match.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MatcherConfiguration {

    @Bean
    List<RestaurantAttributeMatcher> restaurantAttributeMatchers() {
        return List.of(
                new NameMatcher(),
                new CuisineMatcher(),
                new DistanceMatcher(),
                new CustomerRatingMatcher(),
                new AverageCostMatcher()
        );

    }

}
