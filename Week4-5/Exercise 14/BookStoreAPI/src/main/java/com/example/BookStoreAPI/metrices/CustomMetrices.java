package com.example.BookStoreAPI.metrices;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CustomMetrices {

    private final MeterRegistry meterRegistry;

    public CustomMetrices(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void init() {
        // Register custom gauge
        meterRegistry.gauge("custom_gauge_metric", this, CustomMetrices::calculateGaugeValue);
    }

    @PreDestroy
    public void cleanup() {
        // Cleanup logic if necessary
    }

    private double calculateGaugeValue() {
        // Custom logic for metric value
        return 42.0; // Replace with actual metric logic
    }
}
