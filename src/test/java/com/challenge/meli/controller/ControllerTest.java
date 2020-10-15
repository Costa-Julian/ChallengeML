package com.challenge.meli.controller;


import com.challenge.meli.model.Mutants;
import com.challenge.meli.repository.RepoMutant;
import com.challenge.meli.returns.MutantStats;
import com.challenge.meli.service.Methods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
        MutantStats esperado = controller.showStats();

        Assertions.assertEquals(esperado,esperado);
    }
}
