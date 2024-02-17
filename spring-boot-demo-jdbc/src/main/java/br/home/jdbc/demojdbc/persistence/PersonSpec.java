package br.home.jdbc.demojdbc.persistence;

import br.home.jdbc.demojdbc.persistence.entity.Person;

import java.util.List;

public interface PersonSpec {

    List<Person> findAll();
}
