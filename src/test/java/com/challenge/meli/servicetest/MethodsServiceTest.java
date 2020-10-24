package com.challenge.meli.servicetest;


import com.challenge.meli.service.impl.MutantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MethodsServiceTest {

    @Autowired
    private MutantService classMethodsService;


    @Test
    void isMutantTrue() {
        String[] matriz = {"ATGCGA",
                            "CAGTGC",
                            "TTATGT",
                            "AGAAGG"};
        Assertions.assertTrue(classMethodsService.isMutant(matriz));
    }

    @Test
    void isMutantSecondOptionTrue() {
        String[] matriz = {"CTGCGA",
                "CAGTGC",
                "TTATGT",
                "CCCCGG"};
        Assertions.assertTrue(classMethodsService.isMutant(matriz));
    }
    @Test
    void isMutantFalse() {
        String[] matriz = {"ATGCGA",
                "CAGTGC",
                "HHHHHH",
                "AGAAGG"};
        Assertions.assertFalse(classMethodsService.isMutant(matriz));
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
