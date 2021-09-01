package com.spring.msbootcoinrequest.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.spring.msbootcoinrequest.handler.BootCoinRequestHandler;

@Configuration
public class RouterFunctionConfig {

	@Bean
    public RouterFunction<ServerResponse> routes (BootCoinRequestHandler handler) {
        return route(GET("/list"), handler::findAll)
        		.andRoute(GET("/findById/{id}"), handler::findById)
        		.andRoute(POST("/create"), handler::create)
        		.andRoute(DELETE("/delete/{id}"), handler::delete);
    }
}
