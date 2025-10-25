package mst.util;

public class Timer {
    private long start;

    public void start() {
        start = System.nanoTime();
    }

    public long elapsedMillis() {
        long end = System.nanoTime();
        return (end - start) / 1_000_000; // ns -> ms
    }
}
