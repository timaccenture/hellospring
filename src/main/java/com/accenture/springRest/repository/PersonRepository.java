package com.accenture.springRest.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private List<Person> list = new ArrayList<>();
    public void save(Person person) {
        list.add(person);
    }

    public List<Person> findAll(){
        return list;
    }

    public Person findById(Long id){
        return list.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Person not found"));
    }
}
