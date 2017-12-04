package ch.sebooom.tiers.spi.repository;

import ch.sebooom.tiers.domain.model.Tiers;
import ch.sebooom.tiers.domain.repository.TiersRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryTiersRepository implements TiersRepository {
    private final static List<Tiers> TIERS = new ArrayList<>();

    static {

        TIERS.add(new Tiers(1,"Chèvre","Sébastien"));
        TIERS.add(new Tiers(2,"Dubois","Jacques"));


    }

    @Override
    public Tiers findById(Integer id) {
        return TIERS.stream().filter(tier -> tier.getId().equals(id)).findFirst().get();
    }

    @Override
    public List<Tiers> findAll() {
        return TIERS;
    }

    @Override
    public Tiers findByNameAndSurname(String name, String surname) {
        return TIERS.stream().filter(tier -> tier.getNom().equals(name) && tier.getPrenom().equals(surname)).findFirst().get();
    }


}
