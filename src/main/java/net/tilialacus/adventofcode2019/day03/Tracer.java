package net.tilialacus.adventofcode2019.day03;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class Tracer {

    public static final Comparator<Intersection> MANHATTAN = Comparator.comparing(Tracer.Intersection::distance);
    public static final Comparator<Intersection> STEPS = Comparator.comparing(Tracer.Intersection::steps);

    public Set<Point> trace(String line) {
        Set<Point> points = new HashSet<>();
        String[] segments = line.split(",");
        int x = 0;
        int y = 0;
        int totalSteps = 0;
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
                points.add(new Point(x, y, ++totalSteps));
            }
        }
        return points;
    }

    public int closest(Set<Point> one, Set<Point> two) {
        Point point = intersections(one, two)
                .stream()
                .sorted(MANHATTAN)
                .collect(Collectors.toList())
                .get(0).point1;
        return point.distance();
    }

    public List<Intersection> intersections(Set<Point> one, Set<Point> two) {
        Map<Point, Point> map = two.stream().collect(Collectors.toMap(it -> it, it -> it));
        List<Intersection> intersections = new ArrayList<>();
        for (Point point : one) {
            if (map.containsKey(point)) {
                intersections.add(new Intersection(point, map.get(point)));
            }
        }
        return intersections;
    }

    static class Point {
        private final int x;
        private final int y;
        private final int steps;

        public Point(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
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

        public int steps() {
            return steps;
        }
    }

    static class Intersection {
        private final Point point1;
        private final Point point2;

        public Intersection(Point point1, Point point2) {
            this.point1 = point1;
            this.point2 = point2;
        }

        public int distance() {
            return point1.distance();
        }

        public int steps() {
            return point1.steps() + point2.steps();
        }
    }
}
