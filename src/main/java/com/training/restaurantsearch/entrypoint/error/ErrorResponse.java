package com.training.restaurantsearch.entrypoint.error;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {

    private final List<String> messages;

}
