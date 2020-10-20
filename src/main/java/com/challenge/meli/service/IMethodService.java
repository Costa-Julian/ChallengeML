package com.challenge.meli.service;


import com.challenge.meli.model.MutantEntity;

public interface IMethodService {
    boolean isMutant(MutantEntity dna,
                     String[] vectorA,
                     String[] vectorC,
                     String[] vectorG);

    String ratio();
    void saveRecord(Boolean registro);


}
