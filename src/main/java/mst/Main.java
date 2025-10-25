package mst;

import mst.algo.*;
import mst.io.*;
import mst.model.Edge;
import mst.model.Graph;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> edgeListToStrings(List<Edge> edges) {
        List<String> res = new ArrayList<>();
        for (Edge e : edges) res.add(e.u + "-" + e.v + "(" + e.w + ")");
        return res;
    }

    private static OutputRecord.AlgoResult fromPrim(PrimResult pr) {
        OutputRecord.AlgoResult a = new OutputRecord.AlgoResult();
        a.totalCost = pr.totalCost; a.timeMs = pr.timeMs; a.operations = pr.operations;
        a.vertexCount = pr.vertexCount; a.edgeCount = pr.edgeCount; a.mstEdges = edgeListToStrings(pr.mstEdges);
        return a;
    }

    private static OutputRecord.AlgoResult fromKruskal(KruskalResult kr) {
        OutputRecord.AlgoResult a = new OutputRecord.AlgoResult();
        a.totalCost = kr.totalCost; a.timeMs = kr.timeMs; a.operations = kr.operations;
        a.vertexCount = kr.vertexCount; a.edgeCount = kr.edgeCount; a.mstEdges = edgeListToStrings(kr.mstEdges);
        return a;
    }

    public static void main(String[] args) throws IOException {
        String[] inputFiles = {"data/small.json", "data/medium.json", "data/large.json"}; // можно добавить medium.json, large.json
        List<OutputRecord> allRecords = new ArrayList<>();

        for (String path : inputFiles) {
            GraphDataset dataset = InputLoader.loadDataset(path);
            for (GraphDataset.GraphEntry entry : dataset.graphs) {
                Graph g = InputLoader.buildGraph(entry);
                PrimResult pr = Prim.run(g);
                KruskalResult kr = Kruskal.run(g);
                OutputRecord r = new OutputRecord();
                r.graphName = entry.name;
                r.prim = fromPrim(pr);
                r.kruskal = fromKruskal(kr);
                allRecords.add(r);
            }
        }
        OutputWriter.writeJson(allRecords, "results/output.json");
        OutputWriter.writeCsv(allRecords, "results/summary.csv");
        System.out.println("Done. See results/output.json and results/summary.csv");
    }
}
