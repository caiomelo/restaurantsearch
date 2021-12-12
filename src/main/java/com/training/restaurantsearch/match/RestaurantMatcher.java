package com.training.restaurantsearch.match;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.domain.SearchCriteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantMatcher {

    private final List<RestaurantAttributeMatcher> attributeMatchers;

    public RestaurantMatcher(List<RestaurantAttributeMatcher> attributeMatchers) {
        this.attributeMatchers = attributeMatchers;
    }

    public boolean matches(Restaurant restaurant, SearchCriteria criteria) {
        return attributeMatchers.stream().allMatch(matcher -> matcher.matches(restaurant, criteria));
    }

}
