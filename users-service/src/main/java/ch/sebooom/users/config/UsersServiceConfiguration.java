package ch.sebooom.users.config;

import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.domain.model.UserState;
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
                map().getUser().setEtat(source.getEtat());
            }
        });


        mapper.addMappings(new PropertyMap<UserDto, User>() {
            @Override
            protected void configure() {
                map().setId(source.getId());
                map().setPassword(source.getPassword());
                map().setTiersId(source.getTiersId());
                map().setUsername(source.getUsername());

                if(null == source.getEtat()){
                    map().setEtat(UserState.INITIE);
                }else{
                    map().setEtat(source.getEtat());
                }
            }
        });
        return mapper;
    }

    /**
    @Bean
    public ErrorDecoder errorDecoder () {
        return new ErrorDecoder() {
            @Override
            public Exception decode(String s, Response response) {

                if(response.status() == 404){
                    return new TiersNotFoundException("Not found");
                }

                return new IllegalArgumentException("ok fail2");
            }
        };
    }
    */
}
