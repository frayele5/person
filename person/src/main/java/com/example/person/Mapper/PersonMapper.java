package com.example.person.Mapper;


import com.example.person.DtoModels.PersonDto;
import com.example.person.Models.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto toDto(Person person);
    Person toEntity(PersonDto dto);
}