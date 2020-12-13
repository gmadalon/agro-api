package br.com.mgn.agro.service;

import br.com.mgn.agro.entity.Person;

public interface PersonService {
    
    void create(Person person);

    void delete(String id);

    void update(String id, Person person);
    
}
