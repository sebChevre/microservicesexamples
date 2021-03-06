package ch.sebooom.users.service.impl;

import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.domain.repository.UserRepository;
import ch.sebooom.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createNewUser(User user) {
        return userRepository.create(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }


}
