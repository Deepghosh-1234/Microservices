package com.kodewala.order_miceroservice.config;

import feign.RequestInterceptor;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.propagation.Propagator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingFeignConfig {

    @Bean
    public RequestInterceptor tracingFeignInterceptor(
            Tracer tracer,
            Propagator propagator) {

        return requestTemplate -> {

            var span = tracer.currentSpan();
            if (span == null) return;

            propagator.inject(
                    span.context(),
                    requestTemplate,
                    (carrier, key, value) -> carrier.header(key, value)
            );
        };
    }
}
