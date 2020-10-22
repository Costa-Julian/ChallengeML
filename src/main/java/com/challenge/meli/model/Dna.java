package com.challenge.meli.model;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
@Entity
@Table(name = "mutant")
public class Dna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "is_Mutant")
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

    @Override
    public String toString() {
        return "Dna{" +
                "id=" + id +
                ", isMutant=" + isMutant +
                '}';
    }
}
