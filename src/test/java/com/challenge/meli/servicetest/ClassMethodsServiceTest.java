package com.challenge.meli.servicetest;

import com.challenge.meli.model.MutantEntity;
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
        MutantEntity mutant = new MutantEntity();
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
        MutantEntity mutant = new MutantEntity();
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
        MutantEntity mutant = new MutantEntity();
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
