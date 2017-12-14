package ch.sebooom.tiers.spi.repository;

import ch.sebooom.tiers.domain.model.Tiers;
import ch.sebooom.tiers.domain.repository.TiersRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Profile("h2")
@Transactional
public class H2TiersRepository implements TiersRepository{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Tiers findById(Integer id) {
        return entityManager.find(Tiers.class,id);
    }

    @Override
    public List<Tiers> findAll() {
        List tiers = entityManager.createQuery(
                "SELECT tier FROM Tiers tier").getResultList();

        return tiers;
    }

    @Override
    public Tiers findByNameAndSurname(String name, String surname) {
        throw new NotImplementedException();
    }

    @Override
    public Tiers createNewTiers(@RequestParam Tiers tier){
        entityManager.persist(tier);
        entityManager.flush();
        return tier;
    }
}
