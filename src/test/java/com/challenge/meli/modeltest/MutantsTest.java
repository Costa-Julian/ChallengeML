package com.challenge.meli.modeltest;

import com.challenge.meli.model.Mutants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MutantsTest {

    Mutants mutants = new Mutants();

    @Test
    void getSetIdTest() {
        mutants.setId((long)1);
        Assertions.assertEquals(1,mutants.getId());
    }
    @Test
    void getSetIdTestNotEquals() {
        mutants.setId((long)1);
        Assertions.assertNotEquals(2,mutants.getId());
    }

    @Test
    void getSetDnaTest() {
        String[] array = {"AAA","BBB"};
        mutants.setDna(array);
        Assertions.assertArrayEquals(array,mutants.getDna());
    }
    @Test
    void getSetDnaTestNotEquals(){
        String[] array = {"AAA","BBB"};
        mutants.setDna(array);
        String[] newArray =  {"AAC","BBC"};
        Assertions.assertNotEquals(newArray,mutants.getDna());
    }

    @Test
    void constructorTest() {
        String[] array = {"AAA","BBB"};
        Mutants mutante = new Mutants((long)1,array);
        Object esperado = mutante;
        Assertions.assertEquals(esperado,mutante);
    }

    @Test
    void toStringTest() {
        String[] array = {"AAAA"};
        Mutants muti = new Mutants((long) 1 , array);
        String esperado = mutants.toString();
        Assertions.assertEquals(esperado, mutants.toString());
    }
}
