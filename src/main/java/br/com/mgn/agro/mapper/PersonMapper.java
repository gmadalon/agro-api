package br.com.mgn.agro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.mgn.agro.dto.PersonDTO;
import br.com.mgn.agro.dto.PersonGetDTO;
import br.com.mgn.agro.entity.Person;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO toDto(Person entity);

    PersonGetDTO toGetDto(Person entity);

    Person toEntity(PersonDTO dto);

}
