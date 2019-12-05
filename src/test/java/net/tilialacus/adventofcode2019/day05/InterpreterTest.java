package net.tilialacus.adventofcode2019.day05;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterpreterTest {

    @Test
    void simple() {
        Interpreter interpreter = new Interpreter(new int[]{1002,4,3,4,33});
        interpreter.run();
        assertEquals(1002, interpreter.get(0));
    }

    @Test
    void answer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("input1.txt")));
        int[] mem = Stream.of(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Interpreter interpreter = new Interpreter(mem);
        interpreter.input(1);
        interpreter.run();
        assertEquals("0000000007157989", interpreter.output());
    }
}
