package com.training.restaurantsearch.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CuisineDataReaderTest {

    private final DataReader<CuisineData> dataReader = mock(DataReader.class);

    private final CuisineDataReader restaurantDataReader = new CuisineDataReader(dataReader, FILE_NAME);

    @Test
    void itShouldRequireDataReaderToReadRestaurantDataFromFile() throws IOException {
        List<CuisineData> cuisinesData = of(
                new CuisineData(1, "A")
        );
        when(dataReader.read(FILE_NAME, CuisineData.class)).thenReturn(cuisinesData);

        assertEquals(cuisinesData, restaurantDataReader.read());
    }

    private static final String FILE_NAME = "cuisines.csv";

}