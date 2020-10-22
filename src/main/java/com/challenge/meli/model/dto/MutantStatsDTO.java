package com.challenge.meli.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class MutantStatsDTO {
    @JsonProperty("count_human_dna")
    private Long countHumanDna;
    @JsonProperty("count_mutant_dna")
    private Long countMutantDna;
    @JsonProperty("ratio")
    private String ratio;

    public MutantStatsDTO(){}

    public MutantStatsDTO(Long countHumanDna, Long countMutantDna, String ratio) {
        this.countHumanDna = countHumanDna;
        this.countMutantDna = countMutantDna;
        this.ratio = ratio;
    }

    public Long getCountHumanDna() {
        return countHumanDna;
    }

    public void setCountHumanDna(Long countHumanDna) {
        this.countHumanDna = countHumanDna;
    }

    public Long getCountMutantDna() {
        return countMutantDna;
    }

    public void setCountMutantDna(Long countMutantDna) {
        this.countMutantDna = countMutantDna;
    }

    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "MutantStats{" +
                "count_human_dna=" + countHumanDna +
                ", count_mutant_dna=" + countMutantDna +
                ", ratio=" + ratio +
                '}';
    }
}
