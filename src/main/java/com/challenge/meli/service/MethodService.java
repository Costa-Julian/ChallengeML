package com.challenge.meli.service;


import com.challenge.meli.model.Mutant;

public interface MethodService {
    boolean isMutant(Mutant dna,
                     String[] vectorA,
                     String[] vectorC,
                     String[] vectorG);

    String ratio();
    void saveRecord(Boolean registro);


}
