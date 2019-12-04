package net.tilialacus.adventofcode2019.day01;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part1Test {

    private final Part1 fuelCounterUpper = new Part1();

    @Test
    void singleMass() {
        assertEquals(2, fuelCounterUpper.requiredFuel(12));
        assertEquals(2, fuelCounterUpper.requiredFuel(14));
        assertEquals(654, fuelCounterUpper.requiredFuel(1969));
        assertEquals(33583, fuelCounterUpper.requiredFuel(100756));
    }

    @Test
    void answer() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("input1.txt")));
        assertEquals(3198599,
                reader
                .lines()
                .mapToLong(Long::parseLong)
                        .map(fuelCounterUpper::requiredFuel)
                        .sum()
        );
    }
}