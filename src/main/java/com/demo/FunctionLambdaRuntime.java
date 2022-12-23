package com.demo;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime;

import java.net.MalformedURLException;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.micronaut.core.annotation.Nullable;

public class FunctionLambdaRuntime extends AbstractMicronautLambdaRuntime<String, String, String, String> {
    public static void main(String[] args) {
        try {
            new FunctionLambdaRuntime().run(args);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Nullable
    protected RequestHandler<String, String> createRequestHandler(String... args) {
        return new FunctionRequestHandler();
    }
}