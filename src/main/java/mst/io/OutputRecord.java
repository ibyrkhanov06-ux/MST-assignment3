package mst.io;

import java.util.List;

public class OutputRecord {
    public String graphName;
    public AlgoResult prim;
    public AlgoResult kruskal;

    public static class AlgoResult {
        public double totalCost;
        public long timeMs;
        public long operations;
        public int vertexCount;
        public int edgeCount;
        public List<String> mstEdges;
    }
}
