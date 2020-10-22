package com.challenge.meli.model;

import javax.persistence.*;
@Entity
@Table(name = "mutant")
public class Dna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isMutant;

    public Dna(){}

    public Dna(Boolean isMutant) {
        this.isMutant = isMutant;
    }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Boolean getMutant() {
    return isMutant;
  }

  public void setMutant(Boolean mutant) {
    isMutant = mutant;
  }
}
