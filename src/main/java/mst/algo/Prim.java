package mst.algo;

import mst.model.Edge;
import mst.model.Graph;
import mst.util.Timer;
import java.util.*;

public class Prim {

    private static class PQItem {
        int to, from;
        double w;
        PQItem(int from, int to, double w) {
            this.from = from; this.to = to; this.w = w;
        }
    }

    public static PrimResult run(Graph g) {
        Timer timer = new Timer();
        timer.start();

        int n = g.getV();
        boolean[] inMST = new boolean[n];
        List<Edge> mstEdges = new ArrayList<>();
        double totalCost = 0;
        long ops = 0;

        PriorityQueue<PQItem> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a.w));

        inMST[0] = true;
        for (Edge e : g.getAdj().get(0)) {
            pq.add(new PQItem(e.u, e.v, e.w));
            pq.add(new PQItem(e.v, e.u, e.w));
            ops++;
        }

        while (!pq.isEmpty() && mstEdges.size() < n - 1) {
            PQItem cur = pq.poll();
            ops++;
            if (inMST[cur.to]) continue;

            inMST[cur.to] = true;
            mstEdges.add(new Edge(cur.from, cur.to, cur.w));
            totalCost += cur.w;

            for (Edge e : g.getAdj().get(cur.to)) {
                int nxt = (e.u == cur.to) ? e.v : e.u;
                if (!inMST[nxt]) {
                    pq.add(new PQItem(cur.to, nxt, e.w));
                    ops++;
                }
            }
        }

        return new PrimResult(mstEdges, totalCost, g.getV(), g.getE(), ops, timer.elapsedMillis());
    }
}
