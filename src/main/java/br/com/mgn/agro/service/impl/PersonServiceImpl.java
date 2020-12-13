package br.com.mgn.agro.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mgn.agro.entity.Person;
import br.com.mgn.agro.repository.PersonRepository;
import br.com.mgn.agro.service.PersonService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public void create(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(String id) {
        personRepository.findById(id).ifPresent(personRepository::delete);
    }

    @Override
    public void update(String id, Person person) {
        Optional<Person> opPerson = personRepository.findById(id);       
        if( opPerson.isPresent() ) {
            Person dbPerson = opPerson.get();
            dbPerson.setEmail(person.getEmail());   
            dbPerson.setForename(person.getForename());
            dbPerson.setLastname(person.getLastname());
            personRepository.save(dbPerson);
        }
    }
}
