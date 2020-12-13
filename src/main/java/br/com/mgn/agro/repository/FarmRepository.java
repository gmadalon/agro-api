package br.com.mgn.agro.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.mgn.agro.entity.Farm;

public interface FarmRepository extends PagingAndSortingRepository<Farm, String> { 
    
}
