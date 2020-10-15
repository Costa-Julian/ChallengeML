package com.challenge.meli.model;

import javax.persistence.Id;
import java.util.Arrays;

public class Mutants {
    @Id
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
                "id=" + id +
                ", dna=" + Arrays.toString(dna) +
                '}';
    }
}
