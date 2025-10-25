package mst.io;

import java.util.List;

public class GraphDataset {
    public List<GraphEntry> graphs;

    public static class GraphEntry {
        public String name;
        public int vertices;
        public List<JsonEdge> edges;
    }

    public static class JsonEdge {
        public int u;
        public int v;
        public double w;
    }
}
