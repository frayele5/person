package com.example.person.Controllers;

import com.example.person.DtoModels.PersonDto;
import com.example.person.Services.PersonService;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonDto> createPerson( @RequestBody @Valid PersonDto personDto) {
        PersonDto createdPerson = personService.createPerson(personDto);
        return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable ObjectId id) {
        PersonDto personDto = personService.getPersonById(id);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }
}