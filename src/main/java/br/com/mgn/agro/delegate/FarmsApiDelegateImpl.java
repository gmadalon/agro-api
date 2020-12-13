package br.com.mgn.agro.delegate;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.mgn.agro.api.FarmsApiDelegate;
import br.com.mgn.agro.dto.FarmDTO;
import br.com.mgn.agro.dto.FarmGetDTO;

@Service
public class FarmsApiDelegateImpl implements FarmsApiDelegate {

    @Override
    public ResponseEntity<FarmDTO> getFarmById(String id) {
        // TODO Auto-generated method stub
        return FarmsApiDelegate.super.getFarmById(id);
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
    public ResponseEntity<Void> insertFarm(FarmDTO body) {
        // TODO Auto-generated method stub
        return FarmsApiDelegate.super.insertFarm(body);
    }

    @Override
    public ResponseEntity<Void> updateFarm(FarmDTO body, String id) {
        // TODO Auto-generated method stub
        return FarmsApiDelegate.super.updateFarm(body, id);
    }
    
}
