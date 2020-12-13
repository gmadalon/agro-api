package br.com.mgn.agro.delegate;

import java.util.List;

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
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonGetDTO>> getAllPeople() {
        // TODO Auto-generated method stub
        return PeopleApiDelegate.super.getAllPeople();
    }

    @Override
    public ResponseEntity<PersonDTO> getByPersonId(String id) {
        // TODO Auto-generated method stub
        return PeopleApiDelegate.super.getByPersonId(id);
    }

    @Override
    public ResponseEntity<Void> updatePerson(PersonDTO dto, String id) {
        Person person = PersonMapper.INSTANCE.toEntity(dto);
        personService.update(id, person);        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
