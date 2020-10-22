package com.challenge.meli.model.dto;

import java.util.Arrays;

public class MutantDTO {

    private String[] dna;

    public MutantDTO(){}

    public MutantDTO(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    @Override
    public String toString() {
        return "MutantDTO{" +
                "dna=" + Arrays.toString(dna) +
                '}';
    }
}
