package net.tilialacus.adventofcode2019.day03;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TracerTest {

    @Test
    void name() {
        Tracer tracer = new Tracer();
        Set<Tracer.Point> trace1 = tracer.trace("R8,U5,L5,D3");
        Set<Tracer.Point> trace2 = tracer.trace("U7,R6,D4,L4");
        assertEquals(6, tracer.closest(trace1, trace2));
    }


    @Test
    void answer() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("input1.txt")));
        Tracer tracer = new Tracer();
        Set<Tracer.Point> trace1 = tracer.trace(reader.readLine());
        Set<Tracer.Point> trace2 = tracer.trace(reader.readLine());
        assertEquals(896, tracer.closest(trace1, trace2));
    }

    @Test
    void answer2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("input1.txt")));
        Tracer tracer = new Tracer();
        Set<Tracer.Point> trace1 = tracer.trace(reader.readLine());
        Set<Tracer.Point> trace2 = tracer.trace(reader.readLine());
        assertEquals(16524, tracer.intersections(trace1, trace2).stream().sorted(Tracer.STEPS).mapToInt(Tracer.Intersection::steps).findFirst().orElseThrow(IllegalStateException::new));
    }
}