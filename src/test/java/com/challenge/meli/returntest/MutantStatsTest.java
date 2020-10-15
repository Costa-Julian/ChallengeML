package com.challenge.meli.returntest;

import com.challenge.meli.returns.MutantStats;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MutantStatsTest {
    @Autowired
    MutantStats mutantStats;

    @Test
    void getSetCount_human_dnaTest() {
        mutantStats.setCount_human_dna((long) 200);
        Assertions.assertEquals(200,mutantStats.getCount_human_dna());
    }
    @Test
    void getSetCount_human_dnaTestNotEquals() {
        mutantStats.setCount_human_dna((long) 200);
        Assertions.assertNotEquals(222,mutantStats.getCount_human_dna());
    }
    @Test
    void getSetCount_mutant_dnaTest() {
        mutantStats.setCount_mutant_dna((long) 200);
        Assertions.assertEquals(200,mutantStats.getCount_mutant_dna());
    }
    @Test
    void getSetCount_mutant_dnaTestNotEquals() {
        mutantStats.setCount_mutant_dna((long) 200);
        Assertions.assertNotEquals(222,mutantStats.getCount_mutant_dna());
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
        MutantStats mutantStats = new MutantStats((long) 2 , (long) 1,"20.0");
        Object esperado = mutantStats;
        Assertions.assertEquals(esperado,mutantStats);
    }
}
