package ch.sebooom.users.spi.repository;

import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserRepository implements UserRepository {

    private final static List<User> USERS = new ArrayList<>();

    static {

        USERS.add(new User(1,"sebchevre","1234",1));
        USERS.add(new User(2,"root","toor",1));

    }

    @Override
    public User findById(Integer id) {
        return USERS.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<User> findAll() {
        return USERS;
    }

    @Override
    public User findByUserName(String userName) {
        return USERS.stream().filter(user -> user.getUsername().equals(userName)).findFirst().get();
    }
}
