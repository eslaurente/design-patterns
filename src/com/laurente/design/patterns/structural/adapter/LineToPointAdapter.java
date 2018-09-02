package com.laurente.design.patterns.structural.adapter;

import java.util.*;
import java.util.function.Consumer;

public class LineToPointAdapter implements Iterable<Point> {

    private static int count = 0;
    private static Map<Integer, List<Point>> cache = new HashMap<>();
    private int hashCode;

    public LineToPointAdapter(Line line) {
        hashCode = line.hashCode();
        if (cache.get(hashCode) != null) {
            return;
        }

        System.out.println((++count) + ": Generating points for line [" + line.start.x + ", " + line.start.y + "] - [" + line.end.x + ", " + line.end.y + "] (with caching)");

        ArrayList<Point> points = new ArrayList<>();

        int left = Math.min(line.start.x, line.end.x);
        int right = Math.max(line.start.x, line.end.x);
        int top = Math.min(line.start.x, line.end.y);
        int bottom = Math.max(line.start.y, line.end.y);
        int dx = right - left;
        int dy = line.end.y - line.start.y;

        if (dx == 0) {
            for (int y = top; y <= bottom; y++) {
                points.add(new Point(left, y));
            }
        }
        else if (dy == 0) {
            for (int x = left; x <= right; x++) {
                points.add(new Point(x, top));
            }
        }
        cache.put(hashCode, points);
    }

    @Override
    public Iterator<Point> iterator() {
        return cache.get(hashCode).iterator();
    }

    @Override
    public Spliterator<Point> spliterator() {
        return cache.get(hashCode).spliterator();
    }

    @Override
    public void forEach(Consumer<? super Point> action) {
        cache.get(hashCode).forEach(action);
    }
}

