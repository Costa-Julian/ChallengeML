package com.challenge.meli.repository;

import com.challenge.meli.model.DnaSaved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MutantRepository extends JpaRepository<DnaSaved,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO mutant (dna_mutant) VALUES ('mutante')",nativeQuery = true)
    void insertMutantTrue();
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO mutant (dna_mutant) VALUES ('NO mutante')" ,nativeQuery = true)
    void insertMutantFalse();
    
    @Query(value = "select count(*) from mutant where dna_mutant LIKE  'mutante'",nativeQuery = true)
    Long findByMutant();


    @Query(value = "select count(*) from mutant where dna_mutant LIKE  'NO mutante'",nativeQuery = true)
    Long findByHuman();
}
