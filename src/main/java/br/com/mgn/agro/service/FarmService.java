package br.com.mgn.agro.service;

import java.util.Optional;

import br.com.mgn.agro.entity.Farm;

public interface FarmService {

    void create(Farm farm);

    void delete(String id);

    void update(String id, Farm farm);

    Iterable<Farm> getAll();

    Optional<Farm> getById(String id);
    
}
