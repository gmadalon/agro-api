package br.com.mgn.agro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.mgn.agro.dto.FarmDTO;
import br.com.mgn.agro.dto.FarmGetDTO;
import br.com.mgn.agro.entity.Farm;

@Mapper
public interface FarmMapper {


    FarmMapper INSTANCE = Mappers.getMapper(FarmMapper.class);

    FarmDTO toDto(Farm entity);

    FarmGetDTO toGetDto(Farm entity);

    Farm toEntity(FarmDTO dto);

    
}
