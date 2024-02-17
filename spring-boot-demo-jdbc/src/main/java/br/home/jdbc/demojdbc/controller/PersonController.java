package br.home.jdbc.demojdbc.controller;

import br.home.jdbc.demojdbc.persistence.PersonSpec;
import br.home.jdbc.demojdbc.persistence.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    private PersonSpec personSpec;

    @Autowired
    public PersonController(PersonSpec personSpec) {
        this.personSpec = personSpec;
    }

    @GetMapping
    public List<Person> findAll() {
        return personSpec.findAll();
    }

}
