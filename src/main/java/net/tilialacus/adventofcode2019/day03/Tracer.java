package net.tilialacus.adventofcode2019.day03;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Tracer {

    private static final Comparator<Point> MANHATTAN = Comparator.comparing(net.tilialacus.adventofcode2019.day03.Tracer.Point::distance);

    public Set<Point> trace(String line) {
        Set<Point> points = new HashSet<>();
        String[] segments = line.split(",");
        int x = 0;
        int y = 0;
        for (String segment : segments) {
            int steps = Integer.parseInt(segment.substring(1));
            for (int i = 0; i < steps; i++) {
                switch (segment.charAt(0)) {
                    case 'R':
                        x++;
                        break;
                    case 'L':
                        x--;
                        break;
                    case 'U':
                        y++;
                        break;
                    case 'D':
                        y--;
                        break;
                    default:
                        throw new IllegalStateException("Don't understand " + segment);
                }
                points.add(new Point(x, y));
            }
        }
        return points;
    }

    public int closest(Set<Point> one, Set<Point> two) {
        Point point = one.stream()
                .filter(two::contains)
                .sorted(MANHATTAN)
                .collect(Collectors.toList())
                .get(0);
        return point.distance();
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }

        @Override
        public boolean equals(Object obj) {
            Point same = (Point) obj;
            return x == same.x && y == same.y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        public int distance() {
            return abs(x) + abs(y);
        }
    }
}
