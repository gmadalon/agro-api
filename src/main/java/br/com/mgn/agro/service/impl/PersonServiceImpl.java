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
    public Person delete(String id) {
        Person personDeleted = null;
        Optional<Person> opPerson = personRepository.findById(id);
        if(opPerson.isPresent()) {
            personDeleted = opPerson.get();
            personRepository.delete(personDeleted);
        }
        return personDeleted;        
    }

    @Override
    public Person update(String id, Person person) {
        Person personUpdated = null;

        Optional<Person> opPerson = personRepository.findById(id);       
        if( opPerson.isPresent() ) {
            Person dbPerson = opPerson.get();
            dbPerson.setEmail(person.getEmail());   
            dbPerson.setForename(person.getForename());
            dbPerson.setLastname(person.getLastname());
            personUpdated = personRepository.save(dbPerson);
        }
        return personUpdated;
    }

    @Override
    public Iterable<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getById(String id) {
        return personRepository.findById(id);
    }

}
