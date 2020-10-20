package com.challenge.meli.controller;


import com.challenge.meli.model.*;
import com.challenge.meli.repository.MutantRepository;
import com.challenge.meli.returns.MutantStats;
import com.challenge.meli.service.ClassMethodsService;
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
    MutantRepository repo;
    @Autowired
    ClassMethodsService classMethodsService;

    @Test
    void dnaTestOK() {
        String[] matriz = {"CTGCGA",
                "CAGTGC",
                "TTATGT",
                "CCCCGG",
                "CAGTGC",
                "TTATGT"};
        MutantEntity mutants = new MutantEntity();
        mutants.setDna(matriz);
        ResponseEntity<String> retorno = ResponseEntity.ok("{\"Status\" : \"200 ok\"}");
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
        MutantEntity mutants = new MutantEntity();
        mutants.setDna(matriz);
        ResponseEntity<String> retorno = ResponseEntity.ok("{\"Status\" : \"403-Forbidden\"}");
        Assertions.assertNotEquals(retorno, mutantController.dna(mutants));
    }

    @Test
    void showStatsTest() {
        MutantStats esperado =new MutantStats();
        esperado.setCountMutantDna(repo.findByMutant());
        esperado.setCountHumanDna(repo.findByHuman());
        esperado.setRatio(classMethodsService.ratio());
        Assertions.assertEquals(esperado.getRatio(), mutantController.showStats().getRatio());
        Assertions.assertEquals(esperado.getCountHumanDna(), mutantController.showStats().getCountHumanDna());
        Assertions.assertEquals(esperado.getCountMutantDna(), mutantController.showStats().getCountMutantDna());
    }
}
