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

    public static boolean isValid2(int val) {
        if (val < 10) {
            return false;
        }
        boolean twin = false;
        int twinCount = 0;
        int prev = val % 10;
        while ((val /= 10) > 0) {
            int current = val % 10;
            if (current > prev) {
                return false;
            }
            if (current == prev) {
                twinCount++;
            } else {
                if (twinCount == 1) {
                    twin = true;
                }
                twinCount = 0;
            }
            prev = current;
        }
        return twin || twinCount == 1;
    }}
