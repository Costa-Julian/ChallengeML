package com.challenge.meli;


import com.challenge.meli.model.DnaSavedRecords;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DnaSavedRecordsTest {

    DnaSavedRecords dnaSavedRecords = new DnaSavedRecords();


    @Test
    void getAndSetId() {
        long thing = 1;
        dnaSavedRecords.setId(thing);
        Assertions.assertEquals(thing,dnaSavedRecords.getId());
    }
}
