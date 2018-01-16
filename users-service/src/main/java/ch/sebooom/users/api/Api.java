package ch.sebooom.users.api;

import ch.sebooom.users.domain.model.Tiers;
import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.dto.UserDto;
import ch.sebooom.users.dto.UserWithTiersDto;
import ch.sebooom.users.service.UsersService;
import ch.sebooom.users.servicesclient.TiersServicesClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class Api {

    @Autowired
    private UsersService userService;

    @Autowired
    private TiersServicesClient tiersServicesClient;

    @Autowired
    private ModelMapper modelMapper;



    protected Logger logger = LoggerFactory.getLogger(Api.class.getName());


    public Api () {

    }


    @RequestMapping( value = "/users/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fallBackFindById")
    public ResponseEntity<UserWithTiersDto> findById(@PathVariable("id") Integer id) {
        logger.info(String.format("User.findById(%d)", id));
        User user =  userService.findById(id);
        Tiers tier = tiersServicesClient.getTiers(user.getTiersId());
        user.setTiers(tier);

        logger.info(MDC.get("X-B3-TraceId"));


        return new ResponseEntity<UserWithTiersDto>(convertToDtoWithTiers(user),HttpStatus.ACCEPTED);
    }

    public ResponseEntity<UserWithTiersDto> fallBackFindById(@RequestBody UserWithTiersDto userDto, Throwable t){
        return new ResponseEntity<>(HttpStatus.GATEWAY_TIMEOUT);
    }

    @RequestMapping( value = "/users", method = RequestMethod.GET )
    public ResponseEntity<List<UserDto>> findAll() {
        logger.info("User.findAll()");
        List<User> users =  userService.findAll();

        List<UserDto> usersDto = users.stream()
                .map(post -> convertToDto(post))
                .collect(Collectors.toList());

        logger.info(MDC.get("X-B3-TraceId"));

        return new ResponseEntity<List<UserDto>>(usersDto,HttpStatus.ACCEPTED);
    }

    @RequestMapping( value = "/users", method = RequestMethod.POST )
    @HystrixCommand(fallbackMethod = "fallBackCreate")
    public ResponseEntity<UserWithTiersDto> create(@RequestBody UserWithTiersDto userDto) {

        logger.info(String.format("User.create(%s)",userDto));

        Tiers tiers = tiersServicesClient.createTiers(userDto.getTiers());

        User newUser = convertToEntity(userDto.getUser());
        newUser.setTiers(tiers);

        newUser = userService.createNewUser(newUser);



        return new ResponseEntity<UserWithTiersDto>(convertToDtoWithTiers(newUser), HttpStatus.CREATED);
    }

    public ResponseEntity<UserWithTiersDto> fallBackCreate(@RequestBody UserWithTiersDto userDto, Throwable t){
        return new ResponseEntity<UserWithTiersDto>(new UserWithTiersDto(),HttpStatus.GATEWAY_TIMEOUT);
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }

    private UserWithTiersDto convertToDtoWithTiers(User user) {

        UserWithTiersDto userDto = modelMapper.map(user, UserWithTiersDto.class);
        return userDto;
    }

    private User convertToEntity(UserDto userDto)  {

        User user = modelMapper.map(userDto, User.class);
        return user;
    }

}

