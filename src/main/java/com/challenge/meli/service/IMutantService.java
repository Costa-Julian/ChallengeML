package com.challenge.meli.service;



public interface IMutantService {



    boolean isMutant(String[] dna);
    String ratio();
    void saveRecord(Boolean registro);
    Long countMutant();
    Long countHuman();

}
