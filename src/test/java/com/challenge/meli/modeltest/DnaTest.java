package com.challenge.meli.modeltest;


import com.challenge.meli.model.Dna;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.BooleanSupplier;

@SpringBootTest
public class DnaTest {

    Dna dnaSavedRecords = new Dna();


    @Test
    void getAndSetId() {
        dnaSavedRecords.setId((long)1);
        Assertions.assertEquals(1,dnaSavedRecords.getId());
    }
    @Test
    void getAndSetIdNotEquals() {
        dnaSavedRecords.setId((long)1);
        Assertions.assertNotEquals(2,dnaSavedRecords.getId());
    }

    @Test
    void getSetDnaMutantTest() {
       dnaSavedRecords.setMutant(true);
       Assertions.assertTrue(dnaSavedRecords.getMutant());
    }
    @Test
    void getSetDnaMutantTestNotEquals() {
        dnaSavedRecords.setMutant(false);
        Assertions.assertFalse(dnaSavedRecords.getMutant());
    }

    @Test
    void constructorTest() {
        Dna dna = new Dna(false);
        Object esperado = dna;
        Assertions.assertFalse(dna.getMutant());
    }

    @Test
    void toStringTest() {
        Dna dna = new Dna(true);
        String esperado = dna.toString();
        Assertions.assertEquals(esperado,dna.toString());
    }

}
