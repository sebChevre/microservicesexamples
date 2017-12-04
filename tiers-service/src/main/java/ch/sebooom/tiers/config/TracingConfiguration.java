package ch.sebooom.tiers.config;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("tracing")
public class TracingConfiguration {
    //Zipkin tracing configuration
    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

}
