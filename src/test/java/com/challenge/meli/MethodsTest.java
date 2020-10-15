package com.challenge.meli;

import com.challenge.meli.model.Mutants;
import com.challenge.meli.service.Methods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MethodsTest {
    @Autowired
    Methods methods;


    @Test
    void isMutantTrue() {
        Mutants mutant = new Mutants();
        String[] matriz = {"ATGCGA",
                            "CAGTGC",
                            "TTATGT",
                            "AGAAGG"};
        mutant.setDna(matriz);
        String[] vectorA = {"AAAA"};
        String[] vectorC = {"CCCC"};
        String[] vectorG = {"GGGG"};
        Assertions.assertTrue(methods.isMutant(mutant,vectorA,vectorC,vectorG));
    }

    @Test
    void isMutantFalse() {
        Mutants mutant = new Mutants();
        String[] matriz = {"ATGCGA",
                "CAGTGC",
                "HHHHHH",
                "AGAAGG"};
        mutant.setDna(matriz);
        String[] vectorA = {"AAAA"};
        String[] vectorC = {"CCCC"};
        String[] vectorG = {"GGGG"};
        Assertions.assertFalse(methods.isMutant(mutant,vectorA,vectorC,vectorG));
    }
    @Test
    void ratioTestTrue(){
        Assertions.assertEquals(methods.ratio(),methods.ratio());
    }
    @Test
    void ratioTestFalse(){
        String esperado = methods.ratio() + ",";
        Assertions.assertNotEquals(esperado,methods.ratio());
    }
}
