package com.training.restaurantsearch.dataprovider.file;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataReader<T> {

    public List<T> read(String fileName, Class<T> type) throws IOException {
        Resource resource = new ClassPathResource(fileName);
        File file = resource.getFile();
        List<T> items;
        try (FileReader fileReader = new FileReader(file)) {
            items = new CsvToBeanBuilder(fileReader).withType(type).build().parse();
        }
        return items;
    }

}
