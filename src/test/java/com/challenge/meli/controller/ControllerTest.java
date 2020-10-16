package com.challenge.meli.controller;


import com.challenge.meli.model.Mutants;
import com.challenge.meli.repository.RepoMutant;
import com.challenge.meli.returns.MutantStats;
import com.challenge.meli.service.Methods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ControllerTest {
    @Autowired
    Controller controller;
    @Autowired
    RepoMutant repo;
    @Autowired
    Methods methods;

    @Test
    void dnaTestOK() {
        String[] matriz = {"CTGCGA",
                "CAGTGC",
                "TTATGT",
                "CCCCGG",
                "CAGTGC",
                "TTATGT"};
        Mutants mutants = new Mutants();
        mutants.setDna(matriz);
        ResponseEntity<String> retorno = ResponseEntity.ok("200-OK");
        Assertions.assertEquals(retorno,controller.dna(mutants));
    }
    @Test
    void dnaTestForbidden() {
        String[] matriz = {"CTGCGA",
                "CAGTGC",
                "TTATAT",
                "CACCGG",
                "TTATAT",
                "CACCGG"};
        Mutants mutants = new Mutants();
        mutants.setDna(matriz);
        ResponseEntity<String> retorno = ResponseEntity.ok("200-OK");
        Assertions.assertNotEquals(retorno,controller.dna(mutants));
    }

    @Test
    void showStatsTest() {
        MutantStats esperado =new MutantStats();
        esperado.setCount_mutant_dna(repo.countMutant());
        esperado.setCount_human_dna(repo.countHuman());
        esperado.setRatio(methods.ratio());
        Assertions.assertEquals(esperado.getRatio(),controller.showStats().getRatio());
        Assertions.assertEquals(esperado.getCount_human_dna(),controller.showStats().getCount_human_dna());
        Assertions.assertEquals(esperado.getCount_mutant_dna(),controller.showStats().getCount_mutant_dna());
    }
}
