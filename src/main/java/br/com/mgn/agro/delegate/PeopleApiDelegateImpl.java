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
    public ResponseEntity<PersonGetDTO> createPerson(PersonDTO dto) {
        Person person = PersonMapper.INSTANCE.toEntity(dto);
        person = personService.create(person);
        return new ResponseEntity<>(PersonMapper.INSTANCE.toGetDto(person), HttpStatus.CREATED);
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
    public ResponseEntity<PersonGetDTO> getByPersonId(String id) {
        ResponseEntity<PersonGetDTO> response = new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        Optional<Person> opPerson = personService.getById(id);  
        if(opPerson.isPresent()) {
            response = new ResponseEntity<>(PersonMapper.INSTANCE.toGetDto(opPerson.get()), HttpStatus.OK);
        }    
        return response;
    }

    @Override
    public ResponseEntity<PersonGetDTO> updatePerson(PersonDTO dto, String id) {
        ResponseEntity<PersonGetDTO> response = new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        Person person = PersonMapper.INSTANCE.toEntity(dto);
        person = personService.update(id, person);
        if( person != null ) {
            response = new ResponseEntity<>(PersonMapper.INSTANCE.toGetDto(person), HttpStatus.OK);
        }
        return response;
    }
    
}
