package com.challenge.meli.repository;

import com.challenge.meli.model.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MutantRepository extends JpaRepository<Dna,Long> {

    @Query(value = "select count(*) from Dna where isMutant  = true")
    Long findByIsMutantTrue();
    @Query(value = "select count(*) from Dna where isMutant = false")
    Long findByIsMutantFalse();

}
