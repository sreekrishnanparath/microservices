package com.marshal.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {


    @Bean
    public RouteLocator apiGatewayRoutes(RouteLocatorBuilder builder){

        return builder.routes()
                .route(f->f.path("/currency-exchange/**")
                    .uri("lb://currency-exchange"))
                .route(f->f.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(f->f.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .build();

    }
}
