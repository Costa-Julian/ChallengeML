package com.challenge.meli.servicetest;

import com.challenge.meli.service.VectoresService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VectoresServiceTest {
    @Test
    void vectorA() {
        String[] esperado = {"AAAA"};
        Assertions.assertArrayEquals(esperado, VectoresService.getVectorA());
    }
    @Test
    void vectorC() {
        String[] esperado = {"CCCC"};
        Assertions.assertArrayEquals(esperado, VectoresService.getVectorC());
    }
    @Test
    void vectorG() {
        String[] esperado = {"GGGG"};
        Assertions.assertArrayEquals(esperado,VectoresService.getVectorG());
    }
}
