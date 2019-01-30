package Graphs;

import java.util.*;

public class Graph {
    List<Vector> vectorList;
    Graph() {
        vectorList = new ArrayList<>();
    }
    public void addVector(Vector v) {
        vectorList.add(v);
    }
    public void addEdgeBetweenVectorsCycleic(Vector from, Vector to) {
        Edge e = new Edge(from, to);
        Edge e1 = new Edge(to, from);
        from.addEdge(e);
        to.addEdge(e1);
    }
    public void addEdgeBetweenVectorsNonCycleic(Vector from, Vector to) {
        Edge e = new Edge(from, to);
        from.addEdge(e);
    }
}
