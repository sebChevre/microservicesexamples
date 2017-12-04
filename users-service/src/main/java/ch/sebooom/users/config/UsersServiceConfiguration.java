package ch.sebooom.users.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"standalone"})
@ComponentScan("ch.sebooom.users")
public class UsersServiceConfiguration {

}
