package mst.algo;

import mst.model.Edge;
import java.util.List;

public class KruskalResult {
    public final List<Edge> mstEdges;
    public final double totalCost;
    public final int vertexCount;
    public final int edgeCount;
    public final long operations;
    public final long timeMs;

    public KruskalResult(List<Edge> mstEdges,
                         double totalCost,
                         int vertexCount,
                         int edgeCount,
                         long operations,
                         long timeMs) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.vertexCount = vertexCount;
        this.edgeCount = edgeCount;
        this.operations = operations;
        this.timeMs = timeMs;
    }
}
