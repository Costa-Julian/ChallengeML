package com.challenge.meli.repository;

import com.challenge.meli.model.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MutantRepository extends JpaRepository<Dna,Long> {

    @Query(value = "select count(*) from DnaSaved where isMutant  = true")
    Long findByMutant();

    @Query(value = "select count(*) from DnaSaved where isMutant  = false")
    Long findByHuman();

}
