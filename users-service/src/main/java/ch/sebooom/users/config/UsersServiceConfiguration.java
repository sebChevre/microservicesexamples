package ch.sebooom.users.config;

import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.dto.UserDto;
import ch.sebooom.users.dto.UserWithTiersDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"standalone"})
@ComponentScan("ch.sebooom.users")
public class UsersServiceConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.addMappings(new PropertyMap<User,UserWithTiersDto>() {
            @Override
            protected void configure() {
                map().getTiers().setId(source.getTiers().getId());
                map().getTiers().setNom(source.getTiers().getNom());
                map().getTiers().setPrenom(source.getTiers().getPrenom());
                map().getUser().setId(source.getId());
                map().getUser().setUsername(source.getUsername());
                map().getUser().setPassword(source.getPassword());
                map().getUser().setTiersId(source.getTiersId());
            }
        });

        mapper.addMappings(new PropertyMap<UserDto, User>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setPassword(source.getPassword());
                map().setTiersId(source.getTiersId());
                map().setUsername(source.getUsername());
            }
        });
        return mapper;
    }
}
