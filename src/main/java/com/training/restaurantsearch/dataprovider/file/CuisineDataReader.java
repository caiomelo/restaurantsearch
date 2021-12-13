package com.training.restaurantsearch.dataprovider.file;

import java.io.IOException;
import java.util.List;

public class CuisineDataReader {

    public CuisineDataReader(DataReader<CuisineData> dataReader, String fileName) {
        this.dataReader = dataReader;
        this.fileName = fileName;
    }

    private final DataReader<CuisineData> dataReader;
    private final String fileName;

    public List<CuisineData> read() throws IOException {
        return dataReader.read(fileName, CuisineData.class);
    }

}
