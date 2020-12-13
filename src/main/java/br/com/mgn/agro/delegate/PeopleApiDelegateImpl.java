package br.com.mgn.agro.delegate;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mgn.agro.api.PeopleApiDelegate;
import br.com.mgn.agro.dto.PersonDTO;
import br.com.mgn.agro.dto.PersonGetDTO;

@Service
public class PeopleApiDelegateImpl implements PeopleApiDelegate {

    @Override
    public ResponseEntity<Void> createPerson(PersonDTO body) {
        // TODO Auto-generated method stub
        return PeopleApiDelegate.super.createPerson(body);
    }

    @Override
    public ResponseEntity<Void> deletePerson(Long id) {
        // TODO Auto-generated method stub
        return PeopleApiDelegate.super.deletePerson(id);
    }

    @Override
    public ResponseEntity<List<PersonGetDTO>> getAllPeople() {
        // TODO Auto-generated method stub
        return PeopleApiDelegate.super.getAllPeople();
    }

    @Override
    public ResponseEntity<PersonDTO> getByPersonId(Long id) {
        // TODO Auto-generated method stub
        return PeopleApiDelegate.super.getByPersonId(id);
    }

    @Override
    public ResponseEntity<Void> updatePerson(PersonDTO body, Long id) {
        // TODO Auto-generated method stub
        return PeopleApiDelegate.super.updatePerson(body, id);
    }
    
}
