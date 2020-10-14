package com.challenge.meli.service;

import com.challenge.meli.model.Mutant;
import com.challenge.meli.repository.RepoMutant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class Methods implements MethodService{
    @Autowired
    RepoMutant repo;


    @Override
    public boolean isMutant(Mutant mutante, String[] vectorA, String[] vectorC, String[] vectorG) {
        String[] dna = mutante.getDna();
        boolean band = false;
        int filasGral = 0;
        while (filasGral < dna.length ) {
            int ubicGral = 0;
            while (ubicGral<dna[filasGral].length()) {
                if (filasGral + 3 < dna.length &&
                        ubicGral + 3<dna[filasGral].length() &&
                        dna[filasGral].charAt(ubicGral) == vectorA[0].charAt(0) &&
                        dna[filasGral + 1].charAt(ubicGral + 1) == vectorA[0].charAt(1) &&
                        dna[filasGral + 2].charAt(ubicGral + 2) == vectorA[0].charAt(2) &&
                        dna[filasGral + 3].charAt(ubicGral + 3) == vectorA[0].charAt(3) ){
                    for (int filasAG = 0; filasAG<dna.length; filasAG++){
                        for (int lugarAG = 0 ; lugarAG<dna[filasGral].length(); lugarAG++){
                            if (filasAG + 3 < dna.length &&
                                    dna[filasAG].charAt(lugarAG) == vectorG[0].charAt(0) &&
                                    dna[filasAG + 1].charAt(lugarAG) == vectorG[0].charAt(1) &&
                                    dna[filasAG + 2].charAt(lugarAG) == vectorG[0].charAt(2) &&
                                    dna[filasAG + 3].charAt(lugarAG) == vectorG[0].charAt(3) ){
                                band = true;
                                return band;
                            }else if (lugarAG + 3<dna[filasGral].length() &&
                                    dna[filasAG].charAt(lugarAG) == vectorC[0].charAt(0) &&
                                    dna[filasAG].charAt(lugarAG + 1) == vectorC[0].charAt(1) &&
                                    dna[filasAG].charAt(lugarAG + 2) == vectorC[0].charAt(2) &&
                                    dna[filasAG].charAt(lugarAG + 3) == vectorC[0].charAt(3)){
                                band = true;
                                return band;
                            }

                        }

                    }
                }else if(filasGral + 3 < dna.length &&
                        dna[filasGral].charAt(ubicGral) == vectorG[0].charAt(0) &&
                        dna[filasGral + 1].charAt(ubicGral) == vectorG[0].charAt(1) &&
                        dna[filasGral + 2].charAt(ubicGral) == vectorG[0].charAt(2) &&
                        dna[filasGral + 3].charAt(ubicGral) == vectorG[0].charAt(3) ){
                    for (int filasGC = 0; filasGC<dna.length; filasGC++) {
                        for (int lugarGC = 0; lugarGC < dna[filasGral].length(); lugarGC++) {
                            if (lugarGC + 3 < dna[filasGral].length() &&
                                    dna[filasGC].charAt(lugarGC) == vectorC[0].charAt(0) &&
                                    dna[filasGC].charAt(lugarGC + 1) == vectorC[0].charAt(1) &&
                                    dna[filasGC].charAt(lugarGC + 2) == vectorC[0].charAt(2) &&
                                    dna[filasGC].charAt(lugarGC + 3) == vectorC[0].charAt(3)) {
                                band = true;
                                return band;
                            }
                        }
                    }
                }
                ubicGral++;
            }
            filasGral++;
        }
        return band;
    }

    @Override
    public String ratio() {
        double restultado;
        if (repo.countHuman() != 0) {
            restultado = (double)repo.countMutant() /(double)repo.countHuman();
        }else
            restultado = 0;
        DecimalFormat format = new DecimalFormat("#.00");
        return format.format(restultado);
    }

    @Override
    public void saveRecord(Boolean registro) {
        if (registro == true){
            repo.insertMutantTrue();
        }else
            repo.insertMutantFalse();
    }
}
