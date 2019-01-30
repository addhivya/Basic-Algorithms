package Graphs;

import java.util.*;

public class Vector {
    List<Edge> edgeList;
    int number;

    Vector(int number) {
        edgeList = new ArrayList<>();
        this.number = number;
    }

    public void addEdge(Edge e) {
        edgeList.add(e);
    }
}
