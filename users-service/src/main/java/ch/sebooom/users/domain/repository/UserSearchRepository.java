package ch.sebooom.users.domain.repository;

import ch.sebooom.users.domain.model.User;

public interface UserSearchRepository {
    void save(User newUser);
}
