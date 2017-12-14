package ch.sebooom.tiers.service.impl;

import ch.sebooom.tiers.domain.model.Tiers;
import ch.sebooom.tiers.domain.repository.TiersRepository;
import ch.sebooom.tiers.service.TiersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Component
public class TiersServiceImpl implements TiersService{

    @Autowired
    private TiersRepository tiersRepository;

    @Override
    public Tiers findById(Integer id) {
        return tiersRepository.findById(id);
    }

    @Override
    public List<Tiers> findAll() {
        return tiersRepository.findAll();
    }

    @Override
    public Tiers findByNameAndSurname(String name, String surname) {
        throw  new NotImplementedException();
    }

    @Override
    public Tiers createNewTiers(Tiers tier) {
        return tiersRepository.createNewTiers(tier);
    }
}
