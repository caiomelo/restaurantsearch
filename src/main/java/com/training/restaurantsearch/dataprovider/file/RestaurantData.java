package com.training.restaurantsearch.dataprovider.file;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RestaurantData {

    @CsvBindByName(column = "name")
    private String name;
    @CsvBindByName(column = "cuisine_id")
    private Integer cuisineId;
    @CsvBindByName(column = "distance")
    private Integer distance;
    @CsvBindByName(column = "customer_rating")
    private Integer customerRating;
    @CsvBindByName(column = "price")
    private Integer price;

}
