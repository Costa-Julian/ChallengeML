package com.challenge.meli.modeltest;


import com.challenge.meli.model.Dna;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DnaSavedTest {

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
       dnaSavedRecords.setDnaMutant("Mutant");
       Assertions.assertEquals("Mutant",dnaSavedRecords.getDnaMutant());
    }
    @Test
    void getSetDnaMutantTestNotEquals() {
        dnaSavedRecords.setDnaMutant("Mutant");
        Assertions.assertNotEquals("No Mutant",dnaSavedRecords.getDnaMutant());
    }

    @Test
    void constructorTest() {
        Dna dna = new Dna((long) 5 , "Mutant");
        Object esperado = dna;
        Assertions.assertEquals(esperado,dna);
    }

    @Test
    void toStringTest() {
        Dna dna = new Dna((long) 5 , "Mutant");
        String esperado = dna.toString();
        Assertions.assertEquals(esperado,dna.toString());
    }

}
