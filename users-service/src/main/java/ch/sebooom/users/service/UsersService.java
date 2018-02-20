package ch.sebooom.users.service;

import ch.sebooom.users.domain.model.Tiers;
import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsersService {


    User createNewUser(UserDto user, Integer tiersId);

    List<User> findAll();

    User findById(Integer id);

    User activateUserAccount(Integer id);

    ResponseEntity<Tiers> getTiersRemote (Integer id);
}
