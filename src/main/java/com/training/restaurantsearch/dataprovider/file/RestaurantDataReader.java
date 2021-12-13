package com.training.restaurantsearch.dataprovider.file;

import java.io.IOException;
import java.util.List;

public class RestaurantDataReader {

    public RestaurantDataReader(DataReader<RestaurantData> dataReader, String fileName) {
        this.dataReader = dataReader;
        this.fileName = fileName;
    }

    private final DataReader<RestaurantData> dataReader;
    private final String fileName;

    public List<RestaurantData> read() throws IOException {
        return dataReader.read(fileName, RestaurantData.class);
    }

}