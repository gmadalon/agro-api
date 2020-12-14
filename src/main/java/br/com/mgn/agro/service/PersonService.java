package br.com.mgn.agro.service;

import java.util.Optional;

import br.com.mgn.agro.entity.Person;

public interface PersonService {
    
    void create(Person person);

    Person delete(String id);

    Person update(String id, Person person);

    Iterable<Person> getAll();

    Optional<Person> getById(String id);
    
}
