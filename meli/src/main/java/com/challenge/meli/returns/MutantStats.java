package com.challenge.meli.returns;



public class MutantStats {

    private Long count_human_dna;
    private Long count_mutant_dna;
    private String ratio;



    public MutantStats(){}

    public MutantStats(Long count_human_dna, Long count_mutant_dna, String ratio) {
        this.count_human_dna = count_human_dna;
        this.count_mutant_dna = count_mutant_dna;
        this.ratio = ratio;
    }

    public Long getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(Long count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public Long getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public void setCount_mutant_dna(Long count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
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
                "count_human_dna=" + count_human_dna +
                ", count_mutant_dna=" + count_mutant_dna +
                ", ratio=" + ratio +
                '}';
    }
}
