package com.challenge.meli.model;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Mutant {
    @Id
    private Long id;
    private String[] dna;

    public Mutant(){}

    public Mutant(Long id, String[] dna) {
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
        return "Mutant{" +
                "id=" + id +
                ", dna=" + Arrays.toString(dna) +
                '}';
    }
}
