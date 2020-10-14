package com.challenge.meli.model;

import javax.persistence.*;

@Entity
@Table(name = "mutant")
public class DnaSavedRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dna;

    public DnaSavedRecords(){}

    public DnaSavedRecords(Long id, String dna) {
        this.id = id;
        this.dna = dna;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    @Override
    public String toString() {
        return "DnaSavedRecords{" +
                "id=" + id +
                ", dna='" + dna + '\'' +
                '}';
    }
}
