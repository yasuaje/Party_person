package com.asuajeyeison.personparty.controller;

import com.asuajeyeison.personparty.Entity.Party;
import com.asuajeyeison.personparty.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/party")
public class PartyController {

    @Autowired
    private PartyRepository partyRepository;

    @GetMapping("/all")
    public ResponseEntity<Collection<Party>> listarParty(){
        return new ResponseEntity<>(partyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Party> getPartyById(@PathVariable Long id) {
        Party party = partyRepository.findById(id).orElseThrow();

        if (party != null) {
            return new ResponseEntity<>(partyRepository.findById(id).orElseThrow(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> saveParty(@RequestBody Party party){
            return new ResponseEntity<>(partyRepository.save(party),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/partys")
    public ResponseEntity<Void> deleteParty(@PathVariable Long id){
        partyRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    }
