package com.training.restaurantsearch.entrypoint;

import com.training.restaurantsearch.domain.Restaurant;
import com.training.restaurantsearch.usecase.BestRestaurantsByCriteria;
import com.training.restaurantsearch.usecase.SearchCriteria;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RestaurantControllerTest {

    private final BestRestaurantsByCriteria useCase = mock(BestRestaurantsByCriteria.class);
    private final RestaurantController controller = new RestaurantController(useCase);


    @Test
    void itShouldExecuteUseCaseAndReturnItsResponse() {
        List<Restaurant> restaurants = List.of(new Restaurant(NAME, CUISINE, DISTANCE, CUSTOMER_RATING, AVERAGE_COST));
        when(useCase.execute(any(SearchCriteria.class))).thenReturn(restaurants);

        assertEquals(restaurants, controller.getRestaurants(NAME, CUISINE, DISTANCE, CUSTOMER_RATING, AVERAGE_COST));

        ArgumentCaptor<SearchCriteria> criteriaCapture = ArgumentCaptor.forClass(SearchCriteria.class);
        verify(useCase, times(1)).execute(criteriaCapture.capture());
        SearchCriteria capturedCriteria = criteriaCapture.getValue();
        assertEquals(NAME, capturedCriteria.getName());
        assertEquals(CUISINE, capturedCriteria.getCuisine());
        assertEquals(DISTANCE, capturedCriteria.getDistance());
        assertEquals(CUSTOMER_RATING, capturedCriteria.getCustomerRating());
        assertEquals(AVERAGE_COST, capturedCriteria.getAverageCost());
    }

    private static final String NAME = "La pasta";
    private static final String CUISINE = "Italian";
    private static final Integer DISTANCE = 20;
    private static final Integer CUSTOMER_RATING = 4;
    private static final Integer AVERAGE_COST = 35;


}