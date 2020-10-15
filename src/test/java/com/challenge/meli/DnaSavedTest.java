package com.challenge.meli;


import com.challenge.meli.model.DnaSaved;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DnaSavedTest {

    DnaSaved dnaSavedRecords = new DnaSaved();


    @Test
    void getAndSetId() {
        long thing = 1;
        dnaSavedRecords.setId(thing);
        Assertions.assertEquals(thing,dnaSavedRecords.getId());
    }
}
