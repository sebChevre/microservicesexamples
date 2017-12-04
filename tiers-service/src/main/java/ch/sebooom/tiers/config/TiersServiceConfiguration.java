package ch.sebooom.tiers.config;

import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("standalone")
@ComponentScan("ch.sebooom.tiers")
public class TiersServiceConfiguration {

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

}
