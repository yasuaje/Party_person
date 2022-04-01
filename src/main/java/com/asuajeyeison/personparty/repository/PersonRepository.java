package com.asuajeyeison.personparty.repository;

import com.asuajeyeison.personparty.Entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Collection<Person> findAll();
}