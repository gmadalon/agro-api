package br.com.mgn.agro.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mgn.agro.entity.Farm;
import br.com.mgn.agro.repository.FarmRepository;
import br.com.mgn.agro.service.FarmService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FarmService {
    
    private final FarmRepository farmRepository;

    public Farm create(Farm farm) {
        return farmRepository.save(farm);
    }

    public void delete(String id) {
        farmRepository.findById(id).ifPresent(farmRepository::delete);
    }

    public Farm update(String id, Farm farm) {
        Farm farmReturn = null;
        Optional<Farm> opFarm = farmRepository.findById(id);       
        if( opFarm.isPresent() ) {
            Farm dbFarm = opFarm.get();
            dbFarm.setDescription(farm.getDescription());
            dbFarm.setName(farm.getName());
            dbFarm.replaceAll(farm.getKeywords());
            dbFarm.setOwner(farm.getOwner());
            farmReturn = farmRepository.save(dbFarm);
        }
        return farmReturn;
    }

    public Iterable<Farm> getAll() {
        return farmRepository.findAll();
    }

    public Optional<Farm> getById(String id) {
        return farmRepository.findById(id);
    }


}
