package com.example.person.Services;

import com.example.person.DtoModels.PersonDto;
import com.example.person.Mapper.PersonMapper;
import com.example.person.Models.Person;
import com.example.person.Repositories.PersonRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;
    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDto createPerson(PersonDto personDto) {
        Person person = personMapper.toEntity(personDto);
        Person savedPerson = personRepository.save(person);
        logger.info("Person created with ID: {}", savedPerson.getId());
        return personMapper.toDto(savedPerson);
    }

    public PersonDto getPersonById(ObjectId id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Person with ID {} not found", id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
                });
        logger.info("Person found: {}", person);
        return personMapper.toDto(person);
    }
}