package ch.sebooom.users.service.impl;

import ch.sebooom.users.domain.event.UserCreatedEvent;
import ch.sebooom.users.domain.model.Tiers;
import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.domain.repository.UserRepository;
import ch.sebooom.users.dto.UserDto;
import ch.sebooom.users.service.UsersService;
import ch.sebooom.users.servicesclient.TiersServicesClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TiersServicesClient tiersServicesClient;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public User createNewUser(UserDto user, Integer tiersId) {

        User newUser = new User.UserBuilder(user.getUsername(),
                user.getPassword(),
                tiersId).build();

        //newUser.setTiersId(tiersId);


        newUser = userRepository.create(newUser);


        publisher.publishEvent(new UserCreatedEvent(newUser.getId(),newUser.getTiersId()));


        return newUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    public User activateUserAccount(Integer id) {
        User user = userRepository.findById(id);

        user.valideUserAccount();

        return  userRepository.activateUserAccount(user);

    }




    public  ResponseEntity<Tiers> failGetTiers (Integer id) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @HystrixCommand(fallbackMethod = "failGetTiers")
    public ResponseEntity<Tiers> getTiersRemote (Integer id) {
        return tiersServicesClient.getTiers(id);
    }


}
