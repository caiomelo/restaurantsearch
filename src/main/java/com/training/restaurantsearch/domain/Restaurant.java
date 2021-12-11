package com.training.restaurantsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    private String name;
    private String cuisine;
    private Integer distance;
    private Integer customerRating;
    private Integer averageCost;


}
