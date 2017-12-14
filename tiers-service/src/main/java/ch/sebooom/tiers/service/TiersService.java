package ch.sebooom.tiers.service;

import ch.sebooom.tiers.domain.model.Tiers;

import java.util.List;

public interface TiersService {

    public Tiers findById(Integer id);

    public List<Tiers> findAll ();

    public Tiers findByNameAndSurname(String name, String surname);

    Tiers createNewTiers(Tiers tier);
}
