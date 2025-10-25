package mst;

import mst.model.Graph;
import mst.model.Edge;
import mst.algo.Prim;
import mst.algo.Kruskal;
import mst.algo.PrimResult;
import mst.algo.KruskalResult;

public class DesignedGraphDemo {

    public static void main(String[] args) {
        System.out.println("--- BONUS SECTION: Graph Designed in Java ---");

        // создаём граф вручную
        Graph g = new Graph(5);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 1);
        g.addEdge(1, 3, 4);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 4, 5);

        // выводим рёбра графа
        System.out.println("Graph edges:");
        for (Edge e : g.getEdges()) {
            System.out.println(e.u + " - " + e.v + " (" + e.w + ")");
        }

        // запускаем алгоритмы
        PrimResult prim = Prim.run(g);
        KruskalResult kruskal = Kruskal.run(g);

        // выводим результаты
        System.out.println("\n=== Designed Graph Results ===");
        System.out.println("Prim total cost: " + prim.totalCost);
        System.out.println("Kruskal total cost: " + kruskal.totalCost);

        // проверка корректности
        if (prim.totalCost == kruskal.totalCost) {
            System.out.println("✅ Both algorithms produced identical MST costs.");
        } else {
            System.out.println("⚠️ Different MST costs — check implementation!");
        }
    }
}
