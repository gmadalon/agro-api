package br.com.mgn.agro.delegate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mgn.agro.api.FarmsApiDelegate;
import br.com.mgn.agro.dto.FarmDTO;
import br.com.mgn.agro.dto.FarmGetDTO;
import br.com.mgn.agro.entity.Farm;
import br.com.mgn.agro.mapper.FarmMapper;
import br.com.mgn.agro.service.FarmService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FarmsApiDelegateImpl implements FarmsApiDelegate {

    private final FarmService farmService; 

    @Override
    public ResponseEntity<FarmDTO> getFarmById(String id) {

        ResponseEntity<FarmDTO> response = new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        Optional<Farm> opFarm = farmService.getById(id);  
        if(opFarm.isPresent()) {
            response = new ResponseEntity<FarmDTO>(FarmMapper.INSTANCE.toDto(opFarm.get()), HttpStatus.OK);
        }    

        return response;
    }

    @Override
    public ResponseEntity<List<FarmGetDTO>> getFarmsByKeyword(String keyword) {
        // TODO Auto-generated method stub
        return FarmsApiDelegate.super.getFarmsByKeyword(keyword);
    }

    @Override
    public ResponseEntity<List<FarmGetDTO>> getFarmsByPersonId(String id) {
        // TODO Auto-generated method stub
        return FarmsApiDelegate.super.getFarmsByPersonId(id);
    }

    @Override
    public ResponseEntity<List<FarmGetDTO>> getFarmsPeriod(LocalDate beginDate, LocalDate endDate) {
        // TODO Auto-generated method stub
        return FarmsApiDelegate.super.getFarmsPeriod(beginDate, endDate);
    }

    @Override
    public ResponseEntity<FarmGetDTO> insertFarm(FarmDTO dto) {
        farmService.create(FarmMapper.INSTANCE.toEntity(dto));        
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FarmGetDTO> updateFarm(FarmDTO dto, String id) {
        farmService.update(id, FarmMapper.INSTANCE.toEntity(dto));        
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
