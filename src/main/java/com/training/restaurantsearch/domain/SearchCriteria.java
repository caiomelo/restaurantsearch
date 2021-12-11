package com.training.restaurantsearch.domain;

import lombok.Data;

@Data
public class SearchCriteria {

    private final String name;
    private final String cuisine;
    private final Integer distance;
    private final Integer customerRating;
    private final Integer averageCost;

}
