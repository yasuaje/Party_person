package com.asuajeyeison.personparty.controller;

import com.asuajeyeison.personparty.Entity.Party;
import com.asuajeyeison.personparty.Entity.Person;
import com.asuajeyeison.personparty.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/person")
public class PersonaController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/all")
    public ResponseEntity<Collection<Person>> listarPersons(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable long id) {
        Person person = personRepository.findById(id).orElseThrow();
        if (person != null) {
            return new ResponseEntity<>(personRepository.findById(id).orElseThrow(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> savePerson(@RequestBody Person person){
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @GetMapping("/{id}/partys")
    public ResponseEntity<Collection<Party>> ListarFiestasDeLaPersona(@PathVariable Long id){
        Person person = personRepository.findById(id).orElseThrow();

        if (person != null) {
            return new ResponseEntity<>(person.getPartys(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
