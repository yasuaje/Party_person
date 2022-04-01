package com.asuajeyeison.personparty.repository;

import com.asuajeyeison.personparty.Entity.Party;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PartyRepository extends CrudRepository<Party, Long> {
    Collection<Party> findAll();
}