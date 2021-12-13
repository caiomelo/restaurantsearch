package com.training.restaurantsearch.entrypoint;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.usecase.SearchCriteria;
import com.training.restaurantsearch.entrypoint.error.ValidationConstants;
import com.training.restaurantsearch.usecase.BestRestaurantsByCriteria;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    public RestaurantController(BestRestaurantsByCriteria bestRestaurantsByCriteria) {
        this.bestRestaurantsByCriteria = bestRestaurantsByCriteria;
    }

    private final BestRestaurantsByCriteria bestRestaurantsByCriteria;

    @GetMapping
    public List<Restaurant> getRestaurants(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String cuisine,

            @Min(value = ValidationConstants.DISTANCE_MIN, message = ValidationConstants.DISTANCE_MESSAGE)
            @Max(value = ValidationConstants.DISTANCE_MAX, message = ValidationConstants.DISTANCE_MESSAGE)
            @RequestParam(required = false) Integer distance,

            @Min(value = ValidationConstants.CUSTOMER_RATING_MIN, message = ValidationConstants.CUSTOMER_RATING_MESSAGE)
            @Max(value = ValidationConstants.CUSTOMER_RATING_MAX, message = ValidationConstants.CUSTOMER_RATING_MESSAGE)
            @RequestParam(required = false) Integer customerRating,

            @Min(value = ValidationConstants.AVERAGE_COST_MIN, message = ValidationConstants.AVERAGE_COST_MESSAGE)
            @Max(value = ValidationConstants.AVERAGE_COST_MAX, message = ValidationConstants.AVERAGE_COST_MESSAGE)
            @RequestParam(required = false) Integer averageCost) {
        SearchCriteria criteria = new SearchCriteria(name, cuisine, distance, customerRating, averageCost);
        return bestRestaurantsByCriteria.execute(criteria);
    }
}
