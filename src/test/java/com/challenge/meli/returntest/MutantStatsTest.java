package com.challenge.meli.returntest;

import com.challenge.meli.model.dto.MutantStatsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MutantStatsTest {

    MutantStatsDTO mutantStats = new MutantStatsDTO();


    @Test
    void getSetCount_human_dnaTest() {
        mutantStats.setCountHumanDna((long) 200);
        Assertions.assertEquals(200,mutantStats.getCountHumanDna());
    }
    @Test
    void getSetCount_human_dnaTestNotEquals() {
        mutantStats.setCountHumanDna((long) 200);
        Assertions.assertNotEquals(222,mutantStats.getCountHumanDna());
    }
    @Test
    void getSetCount_mutant_dnaTest() {
        mutantStats.setCountMutantDna((long) 200);
        Assertions.assertEquals(200,mutantStats.getCountMutantDna());
    }
    @Test
    void getSetCount_mutant_dnaTestNotEquals() {
        mutantStats.setCountMutantDna((long) 200);
        Assertions.assertNotEquals(222,mutantStats.getCountMutantDna());
    }

    @Test
    void getSetRatioTest() {
        mutantStats.setRatio("20.0");
        Assertions.assertEquals("20.0",mutantStats.getRatio());
    }
    @Test
    void getSetRatioTestNotEquals() {
        mutantStats.setRatio("20.0");
        Assertions.assertNotEquals("22.2",mutantStats.getRatio());
    }
    @Test
    void contructorTest() {
        MutantStatsDTO mutant = new MutantStatsDTO((long) 2 , (long) 1,"20.0");
        Object esperado = mutant;
        Assertions.assertEquals(esperado,mutant);
    }

    @Test
    void toStringTest() {
        MutantStatsDTO stats = new MutantStatsDTO((long) 2 , (long) 1,"20.0");
        String esperado = mutantStats.toString();
        Assertions.assertEquals(esperado, mutantStats.toString());
    }
}
