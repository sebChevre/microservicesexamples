package ch.sebooom.users.domain.repository;

import ch.sebooom.users.domain.model.User;

import java.util.List;

public interface UserRepository {

    User findById (Integer id);

    List<User> findAll ();

    User findByUserName (String userName);

    User create (User user);

    User activateUserAccount (User user);
}
