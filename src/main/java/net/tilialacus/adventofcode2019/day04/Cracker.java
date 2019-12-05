package net.tilialacus.adventofcode2019.day04;

public class Cracker {

    public static boolean isValid(int val) {
        if (val < 10) {
            return false;
        }
        boolean twin = false;
        int prev = val % 10;
        while ((val /= 10) > 0) {
            int current = val % 10;
            if (current > prev) {
                return false;
            }
            if (current == prev) {
                twin = true;
            }
            prev = current;
        }
        return twin;
    }
}
