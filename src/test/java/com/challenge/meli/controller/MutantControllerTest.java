package com.challenge.meli.controller;


import com.challenge.meli.model.dto.MutantDTO;
import com.challenge.meli.model.dto.MutantStatsDTO;
import com.challenge.meli.service.impl.MutantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class MutantControllerTest {
    @Autowired
    MutantController mutantController;

    @Autowired
    MutantService mutantService;

    @Test
    void dnaTestOK() {
        String[] matriz = {"CTGCGA",
                "CAGTGC",
                "TTATGT",
                "CCCCGG",
                "CAGTGC",
                "TTATGT"};
        MutantDTO mutants = new MutantDTO();
        mutants.setDna(matriz);
        ResponseEntity<String> retorno = ResponseEntity.ok("{\"Status\":\"OK\"}");
        Assertions.assertEquals(retorno, mutantController.dna(mutants));
    }
    @Test
    void dnaTestForbidden() {
        String[] matriz = {"CTGCGA",
                "CAGTGC",
                "TTATAT",
                "CACCGG",
                "TTATAT",
                "CACCGG"};
        MutantDTO mutants = new MutantDTO();
        mutants.setDna(matriz);
        ResponseEntity<String> retorno = ResponseEntity.ok("{\"Status\" : \"403-Forbidden\"}");
        Assertions.assertNotEquals(retorno, mutantController.dna(mutants));
    }

    @Test
    void showStatsTest() {
        MutantStatsDTO esperado =new MutantStatsDTO();
        esperado.setCountMutantDna(mutantService.countMutant());
        esperado.setCountHumanDna(mutantService.countHuman());
        esperado.setRatio(mutantService.ratio());
        Assertions.assertEquals(esperado.getRatio(), mutantController.showStats().getRatio());
        Assertions.assertEquals(esperado.getCountHumanDna(), mutantController.showStats().getCountHumanDna());
        Assertions.assertEquals(esperado.getCountMutantDna(), mutantController.showStats().getCountMutantDna());
    }
}
