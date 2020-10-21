package com.challenge.meli.service;


import com.challenge.meli.model.dto.MutantDTO;

public interface IMutantService {

    boolean isMutant(MutantDTO dna);
    String ratio();
    void saveRecord(Boolean registro);
}
