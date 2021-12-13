package com.training.restaurantsearch.dataprovider.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RestaurantDataReaderTest {

    private final DataReader<RestaurantData> dataReader = mock(DataReader.class);

    private final RestaurantDataReader restaurantDataReader = new RestaurantDataReader(dataReader, FILE_NAME);

    @Test
    void itShouldRequireDataReaderToReadRestaurantDataFromFile() throws IOException {
        List<RestaurantData> restaurantsData = of(
                new RestaurantData("A", 1, 20, 4, 40)
        );
        when(dataReader.read(FILE_NAME, RestaurantData.class)).thenReturn(restaurantsData);

        assertEquals(restaurantsData, restaurantDataReader.read());
    }

    private static final String FILE_NAME = "restaurants.csv";

}