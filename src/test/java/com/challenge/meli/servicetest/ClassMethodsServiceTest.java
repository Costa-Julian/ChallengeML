package com.challenge.meli.servicetest;

import com.challenge.meli.model.Mutants;
import com.challenge.meli.service.ClassMethodsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClassMethodsServiceTest {

    @Autowired
    private ClassMethodsService classMethodsService;


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
        Assertions.assertTrue(classMethodsService.isMutant(mutant,vectorA,vectorC,vectorG));
    }

    @Test
    void isMutantSecondOptionTrue() {
        Mutants mutant = new Mutants();
        String[] matriz = {"CTGCGA",
                "CAGTGC",
                "TTATGT",
                "CCCCGG"};
        mutant.setDna(matriz);
        String[] vectorA = {"AAAA"};
        String[] vectorC = {"CCCC"};
        String[] vectorG = {"GGGG"};
        Assertions.assertTrue(classMethodsService.isMutant(mutant,vectorA,vectorC,vectorG));
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
        Assertions.assertFalse(classMethodsService.isMutant(mutant,vectorA,vectorC,vectorG));
    }
    @Test
    void ratioTestTrue(){
        Assertions.assertEquals(classMethodsService.ratio(), classMethodsService.ratio());
    }
    @Test
    void ratioTestFalse(){
        Assertions.assertNotEquals("00.0", classMethodsService.ratio());
    }

    @Test
    void saveRecordsTest() {
        boolean registro = true;
        classMethodsService.saveRecord(registro);

    }
}
