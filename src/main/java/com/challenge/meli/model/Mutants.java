package com.challenge.meli.model;

import java.util.Arrays;

public class Mutants {

    private Long id;
    private String[] dna;

    public Mutants(){}

    public Mutants(Long id, String[] dna) {
        this.id = id;
        this.dna = dna;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    @Override
    public String toString() {
        return "Mutants{" +
                "id=" + id + "," +
                " dna=" + Arrays.toString(dna) + '}';
    }
}
