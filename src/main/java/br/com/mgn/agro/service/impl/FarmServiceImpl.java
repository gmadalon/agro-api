package br.com.mgn.agro.service.impl;

import org.springframework.stereotype.Service;

import br.com.mgn.agro.repository.FarmRepository;
import br.com.mgn.agro.service.FarmService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {
    
    private final FarmRepository farmRepository;




}
