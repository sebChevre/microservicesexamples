package ch.sebooom.users.api;

import ch.sebooom.users.domain.model.Tiers;
import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.dto.UserDto;
import ch.sebooom.users.service.UsersService;
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
    private ModelMapper modelMapper;



    protected Logger logger = LoggerFactory.getLogger(Api.class.getName());


    public Api () {

    }


    @RequestMapping( value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> findById(@PathVariable("id") Integer id) {
        logger.info(String.format("User.findById(%d)", id));
        User user =  userService.findById(id);
        ResponseEntity<Tiers> tiersResponse = userService.getTiersRemote(user.getTiersId());
        //user.setTiers(tier);

        logger.info(MDC.get("X-B3-TraceId"));


        return new ResponseEntity<UserDto>(convertToDto(user),HttpStatus.ACCEPTED);
    }

    @RequestMapping( value = "/users/{id}/activate", method = RequestMethod.PUT)
    public ResponseEntity<UserDto> activateUserAccount(@PathVariable("id") Integer id) {
        logger.info(String.format("User.activateUserAccount(%d)", id));


        User user = userService.activateUserAccount(id);
        logger.info(MDC.get("X-B3-TraceId"));


        return new ResponseEntity<UserDto>(convertToDto(user),HttpStatus.ACCEPTED);
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
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {

        logger.info(String.format("User.create(%s)",userDto));

        ResponseEntity<Tiers> tiersResponse;


        tiersResponse = userService.getTiersRemote(userDto.getTiersId());

        if(tiersResponse.getStatusCode() == HttpStatus.NOT_FOUND){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiIError.message("Tiers not found"));
        }


        User newUser = userService.createNewUser(userDto,tiersResponse.getBody().getId());


        return new ResponseEntity<UserDto>(convertToDto(newUser), HttpStatus.CREATED);
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);

        return userDto;
    }





}

