package com.training.restaurantsearch.dataprovider.file;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class DataReader<T> {

    public List<T> read(String fileName, Class<T> type) throws IOException {
        Resource resource = new ClassPathResource(fileName);
        List<T> items;
        try (InputStreamReader fileReader = new InputStreamReader(resource.getInputStream())) {
            items = new CsvToBeanBuilder(fileReader).withType(type).build().parse();
        }
        return items;
    }

}
