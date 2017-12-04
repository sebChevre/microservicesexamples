package ch.sebooom.tiers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "ch.sebooom.tiers")
public class TiersServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiersServiceApplication.class);
    }
}
