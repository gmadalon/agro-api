package br.com.mgn.agro.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.mgn.agro.entity.Person;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, String> {
}
