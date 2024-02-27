package com.accenture.springRest.controller;

import com.accenture.springRest.repository.Person;
import com.accenture.springRest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personServiceImpl;

    @Autowired
    public PersonController(PersonService personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }
    @PostMapping("/api/person/v1")
    public void createNewPerson(@RequestBody(required = false) Person person) {
        personServiceImpl.create(person);
    }
    @GetMapping("api/person/v1")
    public ResponseEntity<List<Person>> getAllPersons(){
        return new ResponseEntity<>(personServiceImpl.fillAll(), HttpStatus.OK);
    }
    @GetMapping("api/person/v1/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(personServiceImpl.getById(id), HttpStatus.OK);
    }
}
