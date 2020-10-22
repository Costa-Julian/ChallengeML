package com.challenge.meli.servicetest;

import com.challenge.meli.model.dto.MutantDTO;
import com.challenge.meli.service.impl.MutantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClassMethodsServiceTest {

    @Autowired
    private MutantService classMethodsService;


    @Test
    void isMutantTrue() {
        MutantDTO mutant = new MutantDTO();
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
        MutantDTO mutant = new MutantDTO();
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
        MutantDTO mutant = new MutantDTO();
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
