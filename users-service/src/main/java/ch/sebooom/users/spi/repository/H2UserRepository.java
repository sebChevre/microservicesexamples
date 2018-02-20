package ch.sebooom.users.spi.repository;

import ch.sebooom.users.domain.model.User;
import ch.sebooom.users.domain.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Profile("h2")
@Transactional
public class H2UserRepository implements UserRepository{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findById(Integer id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public List<User> findAll() {
        List listPersons = entityManager.createQuery(
                "SELECT user FROM User user").getResultList();

        return listPersons;
    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public User create(User user) {
        entityManager.persist(user);
        entityManager.flush();
        return user;
    }

    @Override
    public User activateUserAccount(User user) {
        User u = entityManager.merge(user);
        entityManager.flush();
        return u;
    }
}
