package net.tilialacus.adventofcode2019.day01;

public class Part1 {
    public long requiredFuel(long mass) {
        return mass / 3 - 2;
    }

    public long totalRequiredFuel(long mass) {
        return accumulator(requiredFuel(mass));
    }

    private long accumulator(long mass) {
        if (mass <= 0) {
            return 0;
        } else {
            return mass + accumulator(requiredFuel(mass));
        }
    }
}