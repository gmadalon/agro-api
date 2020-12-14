package br.com.mgn.agro.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mgn.agro.entity.Farm;
import br.com.mgn.agro.repository.FarmRepository;
import br.com.mgn.agro.service.FarmService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {
    
    private final FarmRepository farmRepository;

    @Override
    public void create(Farm farm) {
        farmRepository.save(farm);
    }

    @Override
    public void delete(String id) {
        farmRepository.findById(id).ifPresent(farmRepository::delete);
    }

    @Override
    public void update(String id, Farm farm) {
        Optional<Farm> opFarm = farmRepository.findById(id);       
        if( opFarm.isPresent() ) {
            Farm dbFarm = opFarm.get();
            dbFarm.setDescription(farm.getDescription());
            dbFarm.setName(farm.getName());
            dbFarm.replaceAll(farm.getKeywords());
            dbFarm.setOwner(farm.getOwner());
            farmRepository.save(dbFarm);
        }
    }

    @Override
    public Iterable<Farm> getAll() {
        return farmRepository.findAll();
    }

    @Override
    public Optional<Farm> getById(String id) {
        return farmRepository.findById(id);
    }



}
