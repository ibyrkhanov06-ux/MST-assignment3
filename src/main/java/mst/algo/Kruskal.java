package mst.algo;

import mst.model.Edge;
import mst.model.Graph;
import mst.util.DisjointSetUnion;
import mst.util.Timer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    public static KruskalResult run(Graph g) {
        Timer timer = new Timer();
        timer.start();

        int n = g.getV();
        List<Edge> edges = new ArrayList<>(g.getEdges());

        DisjointSetUnion dsu = new DisjointSetUnion(n);

        edges.sort((a, b) -> {
            dsu.comparisons++;
            return Double.compare(a.w, b.w);
        });

        List<Edge> mst = new ArrayList<>();
        double totalCost = 0.0;

        for (Edge e : edges) {
            int ru = dsu.find(e.u);
            int rv = dsu.find(e.v);

            if (ru != rv) {
                boolean merged = dsu.union(ru, rv);
                if (merged) {
                    mst.add(e);
                    totalCost += e.w;
                    if (mst.size() == n - 1) break;
                }
            }
        }

        long elapsed = timer.elapsedMillis();
        long ops = dsu.totalOps();

        return new KruskalResult(mst, totalCost, g.getV(), g.getE(), ops, elapsed);
    }
}