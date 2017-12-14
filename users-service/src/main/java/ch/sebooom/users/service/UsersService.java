package ch.sebooom.users.service;

import ch.sebooom.users.domain.model.User;

import java.util.List;

public interface UsersService {


    User createNewUser(User user);

    List<User> findAll();

    User findById(Integer id);
}
