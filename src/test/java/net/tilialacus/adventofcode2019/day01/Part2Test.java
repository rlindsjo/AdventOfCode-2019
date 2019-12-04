package net.tilialacus.adventofcode2019.day01;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Part2Test {

    private final Part1 fuelCounterUpper = new Part1();

    @Test
    void singleMass() {
        assertEquals(50346, fuelCounterUpper.totalRequiredFuel(100756));
    }

    @Test
    void answer() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("input1.txt")));
        assertEquals(4795042,
                reader
                .lines()
                .mapToLong(Long::parseLong)
                        .map(fuelCounterUpper::totalRequiredFuel)
                        .sum()
        );
    }
}