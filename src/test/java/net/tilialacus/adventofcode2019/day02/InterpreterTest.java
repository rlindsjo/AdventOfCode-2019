package net.tilialacus.adventofcode2019.day02;

import net.tilialacus.adventofcode2019.day01.Part1;
import net.tilialacus.adventofcode2019.day02.Interpreter;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterpreterTest {


    @Test
    void simple() {
        Interpreter interpreter = new Interpreter(new int[]{1,1,1,4,99,5,6,0,99});
        interpreter.run();
        assertEquals(30, interpreter.get(0));
    }

    @Test
    void answer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("input1.txt")));
        int[] mem = Stream.of(reader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Interpreter interpreter = new Interpreter(mem);
        mem[1] = 12;
        mem[2] = 2;
        interpreter.run();
        assertEquals(8017076, interpreter.get(0));
    }
}