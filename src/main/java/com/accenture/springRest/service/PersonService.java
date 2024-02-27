package com.accenture.springRest.service;

import com.accenture.springRest.repository.Person;

import java.util.List;

public interface PersonService {
    void create(Person person);
    List<Person> fillAll();
}
