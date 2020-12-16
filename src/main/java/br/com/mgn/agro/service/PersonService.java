package br.com.mgn.agro.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mgn.agro.entity.Person;
import br.com.mgn.agro.repository.PersonRepository;
import br.com.mgn.agro.service.PersonService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person delete(String id) {
        Person personDeleted = null;
        Optional<Person> opPerson = personRepository.findById(id);
        if(opPerson.isPresent()) {
            personDeleted = opPerson.get();
            personRepository.delete(personDeleted);
        }
        return personDeleted;        
    }

    public Person update(String id, Person person) {
        Person personUpdated = null;

        Optional<Person> opPerson = personRepository.findById(id);       
        if( opPerson.isPresent() ) {
            Person dbPerson = opPerson.get();
            dbPerson.setEmail(person.getEmail());   
            dbPerson.setForename(person.getForename());
            dbPerson.setLastName(person.getLastName());
            personUpdated = personRepository.save(dbPerson);
        }
        return personUpdated;
    }

    public Iterable<Person> getAll() {
        return personRepository.findAll();
    }

    public Optional<Person> getById(String id) {
        return personRepository.findById(id);
    }

}
