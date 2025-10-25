package mst.io;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutputWriter {

    public static void writeJson(List<OutputRecord> records, String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(path), records);
    }

    public static void writeCsv(List<OutputRecord> records, String path) throws IOException {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write("graph,algo,totalCost,timeMs,operations,vertices,edges\n");
            for (OutputRecord r : records) {
                fw.write(String.format(
                        "%s,Prim,%.4f,%d,%d,%d,%d\n",
                        r.graphName, r.prim.totalCost, r.prim.timeMs, r.prim.operations,
                        r.prim.vertexCount, r.prim.edgeCount
                ));
                fw.write(String.format(
                        "%s,Kruskal,%.4f,%d,%d,%d,%d\n",
                        r.graphName, r.kruskal.totalCost, r.kruskal.timeMs, r.kruskal.operations,
                        r.kruskal.vertexCount, r.kruskal.edgeCount
                ));
            }
        }
    }
}
