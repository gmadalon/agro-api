package br.com.mgn.agro.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.mgn.agro.dto.FarmDTO;
import br.com.mgn.agro.dto.FarmGetDTO;
import br.com.mgn.agro.entity.Farm;

@Mapper
public interface FarmMapper {


    FarmMapper INSTANCE = Mappers.getMapper(FarmMapper.class);

    @Mapping(source="entity.owner.id", target="ownerId")
    FarmDTO toDto(Farm entity);

    @Mapping(source="entity.owner.id", target="ownerId")
    FarmGetDTO toGetDto(Farm entity);

    @Mapping(source="dto.ownerId", target="owner.id")
    Farm toEntity(FarmDTO dto);

    
}
