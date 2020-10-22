package com.challenge.meli.modeltest;

import com.challenge.meli.model.dto.MutantDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MutantEntityTest {

    MutantDTO mutants = new MutantDTO();



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
        MutantDTO mutante = new MutantDTO(array);
        Object esperado = mutante;
        Assertions.assertEquals(esperado,mutante);
    }

    @Test
    void toStringTest() {
        String[] array = {"AAAA"};
        MutantDTO muti = new MutantDTO(array);
        String esperado = mutants.toString();
        Assertions.assertEquals(esperado, mutants.toString());
    }
}
