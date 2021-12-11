package com.training.restaurantsearch.domain;

import lombok.Data;

@Data
public class Restaurant {

    private String name;
    private String cuisine;
    private Integer distance;
    private Integer customerRating;
    private Integer averageCost;


}
