package com.training.restaurantsearch.dataprovider.file;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class DataReaderTest {

    private final DataReader<UserData> reader = new DataReader<>();

    @Test
    void itShouldReadDataFromFileAndParseToGivenTypeObjects() throws IOException {
        List<UserData> usersData = reader.read(FILE_NAME, UserData.class);
        assertEquals(3, usersData.size());

        for (UserData user : usersData) {
            if (user.getId().equals(1)) assertEquals("user1name", user.getName());
            else if (user.getId().equals(2)) assertEquals("user2name", user.getName());
            else if (user.getId().equals(3)) assertEquals("user3name", user.getName());
            else fail("Data not recognized");
        }
    }

    private static final String FILE_NAME = "users.csv";

}