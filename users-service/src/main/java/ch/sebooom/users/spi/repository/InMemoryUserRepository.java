package ch.sebooom.users.spi.repository;

import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.domain.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("testRepo")
public class InMemoryUserRepository implements UserRepository {

    private final static List<User> USERS = new ArrayList<>();

    static {

        USERS.add(new User.UserBuilder("sebchevre","1234",1).id(1).build());
        USERS.add(new User.UserBuilder("root","toor",1).id(2).build());

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

    @Override
    public User create(User user) {
        throw new NotImplementedException();
    }

    @Override
    public User activateUserAccount(User user) {
        throw new NotImplementedException();
    }
}
