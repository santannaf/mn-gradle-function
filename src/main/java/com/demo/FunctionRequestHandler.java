package com.demo;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.function.aws.MicronautRequestHandler;
import jakarta.inject.Inject;

import java.util.Collections;

public class FunctionRequestHandler extends MicronautRequestHandler<String, String> {

    @Inject
    ObjectMapper objectMapper;

    @Override
    public String execute(String input) {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        try {
            String json = objectMapper.writeValueAsString(Collections.singletonMap("message", "Hello World"));
            response.setStatusCode(200);
            response.setBody(json);
        } catch (JsonProcessingException e) {
            response.setStatusCode(500);
        }
        return "Hellooooo everyoneeee!!!";
    }
}
