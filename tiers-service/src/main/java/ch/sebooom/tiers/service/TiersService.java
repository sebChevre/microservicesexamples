package ch.sebooom.tiers.service;

import ch.sebooom.tiers.domain.model.Tiers;

import java.util.List;
import java.util.Optional;

public interface TiersService {

    public Optional<Tiers> findById(Integer id);

    public List<Tiers> findAll ();

    public Tiers findByNameAndSurname(String name, String surname);

    Tiers createNewTiers(Tiers tier);
}
