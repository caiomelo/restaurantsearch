package com.training.restaurantsearch.config;

import com.training.restaurantsearch.dataprovider.file.CuisineDataReader;
import com.training.restaurantsearch.dataprovider.file.DataReader;
import com.training.restaurantsearch.dataprovider.file.RestaurantDataReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataReaderConfiguration {

    private final String restaurantsFile;
    private final String cuisinesFile;

    public DataReaderConfiguration(
            @Value("${app.file.restaurants}")
                    String restaurantsFile,
            @Value("${app.file.cuisines}")
                    String cuisinesFile
    ) {
        this.restaurantsFile = restaurantsFile;
        this.cuisinesFile = cuisinesFile;
    }

    @Bean
    public RestaurantDataReader restaurantDataReader() {
        return new RestaurantDataReader(new DataReader<>(), restaurantsFile);
    }

    @Bean
    public CuisineDataReader cuisineDataReader() {
        return new CuisineDataReader(new DataReader<>(), cuisinesFile);
    }

}
