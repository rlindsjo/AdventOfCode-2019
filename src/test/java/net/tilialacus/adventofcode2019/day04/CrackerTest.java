package net.tilialacus.adventofcode2019.day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CrackerTest {

    @Test
    void valid() {
        assertTrue(Cracker.isValid(111111));
        assertTrue(Cracker.isValid(122345));
    }

    @Test
    void invalid() {
        assertFalse(Cracker.isValid(111110));
        assertFalse(Cracker.isValid(543321));
    }

    @Test
    void answer() {
        int sum = 0;
        for (int attempt = 387638; attempt <= 919123; attempt++) {
            if (Cracker.isValid(attempt)) {
                sum++;
            }
        }
        assertEquals(466, sum);
    }
}