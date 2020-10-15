package com.challenge.meli.controller;


import com.challenge.meli.model.Mutants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class ControllerTest {
    @Autowired
    Controller controller;

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
}
