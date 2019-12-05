package net.tilialacus.adventofcode2019.day02;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterpreterTest2 {

    @Test
    void answer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("input1.txt")));
        int[] mem = Stream.of(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();

        assertEquals(3146, find(mem, 19690720));
    }

    private int find(int[] mem, int expected) {
        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb ++) {
                Interpreter interpreter = new Interpreter(mem.clone());
                interpreter.write(1, noun);
                interpreter.write(2, verb);
                interpreter.run();
                if (interpreter.read(0) == expected) {
                    return 100 * noun + verb;
                }
            }
        }
        throw new IllegalArgumentException(expected + " never matched");
    }
}