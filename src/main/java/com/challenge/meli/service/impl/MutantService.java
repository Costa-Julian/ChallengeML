package com.challenge.meli.service.impl;

import com.challenge.meli.model.*;
import com.challenge.meli.repository.MutantRepository;
import com.challenge.meli.service.IMutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class MutantService implements IMutantService {

    @Autowired
    MutantRepository mutantRepository;

    private static String[] vectorA = {"AAAA"};
    private static String[] vectorC = {"CCCC"};
    private static String[] vectorG = {"GGGG"};



    @Override
    public boolean isMutant(String[] dna) {
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
                    int filasAG = 0;
                    while (filasAG<dna.length){
                        int lugarAG = 0;
                        while (lugarAG<dna[filasGral].length()){
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
                            lugarAG++;
                        }
                        filasAG++;
                    }
                }else if(filasGral + 3 < dna.length &&
                        dna[filasGral].charAt(ubicGral) == vectorG[0].charAt(0) &&
                        dna[filasGral + 1].charAt(ubicGral) == vectorG[0].charAt(1) &&
                        dna[filasGral + 2].charAt(ubicGral) == vectorG[0].charAt(2) &&
                        dna[filasGral + 3].charAt(ubicGral) == vectorG[0].charAt(3) ){
                    int filasGC = 0;
                    while ( filasGC<dna.length) {
                        int lugarGC = 0;
                        while (lugarGC < dna[filasGral].length()) {
                            if (lugarGC + 3 < dna[filasGral].length() &&
                                    dna[filasGC].charAt(lugarGC) == vectorC[0].charAt(0) &&
                                    dna[filasGC].charAt(lugarGC + 1) == vectorC[0].charAt(1) &&
                                    dna[filasGC].charAt(lugarGC + 2) == vectorC[0].charAt(2) &&
                                    dna[filasGC].charAt(lugarGC + 3) == vectorC[0].charAt(3)) {
                                band = true;
                                return band;
                            }
                            lugarGC++;
                        }
                        filasGC++;
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
        double restultado = mutantRepository.findByIsMutantFalse() != 0 ?
                        (double) mutantRepository.findByIsMutantTrue() /
                        (double) mutantRepository.findByIsMutantFalse() :  0;
        return new DecimalFormat("0.00#").format(restultado);
    }

    @Override
    public void saveRecord(Boolean registro) {
      mutantRepository.saveAndFlush(new Dna(registro));
    }

    @Override
    public Long countMutant() {
        return mutantRepository.findByIsMutantTrue();
    }

    @Override
    public Long countHuman() {
        return mutantRepository.findByIsMutantFalse();
    }


}
