package ch.sebooom.tiers.domain.repository;

import ch.sebooom.tiers.domain.model.Tiers;

import java.util.List;

public interface TiersRepository {

    public Tiers findById(Integer id);

    public List<Tiers> findAll ();

    public Tiers findByNameAndSurname(String name, String surname);
}
