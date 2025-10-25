package mst.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import mst.model.Graph;
import java.io.File;
import java.io.IOException;

public class InputLoader {

    public static GraphDataset loadDataset(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(path), GraphDataset.class);
    }

    public static Graph buildGraph(GraphDataset.GraphEntry entry) {
        Graph g = new Graph(entry.vertices);
        for (GraphDataset.JsonEdge e : entry.edges) {
            g.addEdge(e.u, e.v, e.w);
        }
        return g;
    }
}
