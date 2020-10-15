package com.challenge.meli.model;

import javax.persistence.*;
@Entity
@Table(name = "mutant")
public class DnaSaved {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dnaMutant;

    public DnaSaved(){}

    public DnaSaved(Long id, String dna) {
        this.id = id;
        this.dnaMutant = dna;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDnaMutant() {
        return dnaMutant;
    }

    public void setDnaMutant(String dnaMutant) {
        this.dnaMutant = dnaMutant;
    }

    @Override
    public String toString() {
        return "DnaSaved{" +
                "id=" + id +
                ", dna='" + dnaMutant + '\'' +
                '}';
    }
}
