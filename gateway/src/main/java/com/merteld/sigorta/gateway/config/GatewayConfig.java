package com.merteld.sigorta.gateway.config;

import com.merteld.sigorta.gateway.service.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    private final JwtAuthenticationFilter filter;

    public GatewayConfig(JwtAuthenticationFilter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/v1/user/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://user-service"))

//                .route("job-service", r -> r.path("/v1/job-service/**")
//                        .filters(f -> f.filter(filter))
//                        .uri("lb://job-service"))

                .route("policy-service", r -> r.path("/v1/policy/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://policy-service"))

                .route("auth-service", r -> r.path("/v1/auth/**")
                        .uri("lb://auth-service"))

                .route("customer-service", r -> r.path("/v1/customer/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://customer-service"))
                .build();
    }
}