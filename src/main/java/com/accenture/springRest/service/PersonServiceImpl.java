package com.accenture.springRest.service;

import com.accenture.springRest.repository.Person;
import com.accenture.springRest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void create(Person person) {
        if (person.getFirstName().equals("Susi")) {
            throw new RuntimeException("Susi nicht erwünscht");
        }
        personRepository.save(person);

    }
    @Override
    public List<Person> fillAll() {
        List<Person> persons = personRepository.findAll();
        return persons.stream().sorted(Comparator.comparing(Person::getFirstName)).toList();
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id);
    }


}
