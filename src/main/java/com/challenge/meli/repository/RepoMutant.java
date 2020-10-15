package com.challenge.meli.repository;

import com.challenge.meli.model.DnaSavedRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RepoMutant extends JpaRepository<DnaSavedRecords,Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO mutant (dna)  VALUES ('mutante')" , nativeQuery = true)
    void insertMutantTrue();
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO mutant (dna) VALUES ('NO mutante')" , nativeQuery = true )
    void insertMutantFalse();

    @Query(value = "select count(*) from mutant where dna LIKE  'mutante'" , nativeQuery = true)
    long countMutant();

    @Query(value = "select count(*) from mutant where dna LIKE  'NO mutante'" , nativeQuery = true)
    long countHuman();
}
