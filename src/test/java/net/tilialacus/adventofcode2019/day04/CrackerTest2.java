package net.tilialacus.adventofcode2019.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrackerTest2 {

    @Test
    void valid() {
        assertTrue(Cracker.isValid2(112233));
        assertTrue(Cracker.isValid2(111122));
    }

    @Test
    void invalid() {
        assertFalse(Cracker.isValid2(123444));
        assertFalse(Cracker.isValid2(543321));
    }

    @Test
    void answer() {
        int sum = 0;
        for (int attempt = 387638; attempt <= 919123; attempt++) {
            if (Cracker.isValid2(attempt)) {
                sum++;
            }
        }
        assertEquals(292, sum);
    }
}