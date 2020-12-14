package br.com.mgn.agro.delegate;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mgn.agro.api.PeopleApiDelegate;
import br.com.mgn.agro.dto.PersonDTO;
import br.com.mgn.agro.dto.PersonGetDTO;
import br.com.mgn.agro.entity.Person;
import br.com.mgn.agro.mapper.PersonMapper;
import br.com.mgn.agro.service.PersonService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PeopleApiDelegateImpl implements PeopleApiDelegate {

    private final PersonService personService;

    @Override
    public ResponseEntity<Void> createPerson(PersonDTO dto) {
        Person person = PersonMapper.INSTANCE.toEntity(dto);
        personService.create(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deletePerson(String id) {
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        Person person = personService.delete(id);
        if(person != null) {
            response = new ResponseEntity<>(HttpStatus.OK);
        } 
        return response;
    }

    @Override
    public ResponseEntity<List<PersonGetDTO>> getAllPeople() {
        List<PersonGetDTO> peopleDto = PersonMapper.INSTANCE.toDto(personService.getAll());        
        return new ResponseEntity<>(peopleDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDTO> getByPersonId(String id) {
        ResponseEntity<PersonDTO> response = new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        Optional<Person> opPerson = personService.getById(id);  
        if(opPerson.isPresent()) {
            new ResponseEntity<>(PersonMapper.INSTANCE.toDto(opPerson.get()), HttpStatus.OK);
        }    
        return response;
    }

    @Override
    public ResponseEntity<Void> updatePerson(PersonDTO dto, String id) {
        Person person = PersonMapper.INSTANCE.toEntity(dto);
        personService.update(id, person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
